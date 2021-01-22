package Service.Impl;

import Repository.ExpenseRepository;
import Repository.UserRepository;
import Service.IExpenseManager;
import javafx.util.Pair;
import models.*;

import java.time.LocalDateTime;
import java.util.*;

public class ExpenseManagerImpl implements IExpenseManager {


    @Override
    public void addExpense(String paidBy, String expenseDesc, LocalDateTime expenseDate, List<Split> splitIntoUsers, SplitType splitType, Double amount) {
        Expense expense = createExpense(paidBy,expenseDesc,expenseDate,splitIntoUsers,splitType,amount);
        ExpenseRepository.expenseMap.putIfAbsent(expense.getExpenseId(),expense);
        assignExpensetoUser(expense,paidBy);
    }

    public void assignExpensetoUser(Expense expense, String paidBy){
        UserRepository.userBalanceMap.putIfAbsent(paidBy,new HashMap<>());
        for (Split split : expense.getSplitInto()){
            String paidTo = split.getUserId();
            if(!paidTo.equals(paidBy)){
              Map<String, Double> balancedFrom = UserRepository.userBalanceMap.get(paidBy);
              if(!balancedFrom.containsKey(paidTo)){
                  balancedFrom.put(paidTo, 0.0);
              }else{
                  balancedFrom.put(paidTo, balancedFrom.get(paidTo) + split.getAmount());
              }
            }
        }
    }


    public Expense createExpense(String userId, String expenseDesc, LocalDateTime expenseDate, List<Split> splitIntoUsers, SplitType splitType, Double amount){
        String  expenseId = UUID.randomUUID().toString();
        switch (splitType){
            case EQUAL:
                int numOfusers = splitIntoUsers.size();
                for(Split split:splitIntoUsers){
                    split.setAmount(amount/numOfusers);
                }
              return  EqualExpense.builder()
                        .expenseId(expenseId)
                        .expenseDesc(expenseDesc)
                        .createdDate(expenseDate)
                        .paidBy(userId)
                        .splitInto(splitIntoUsers)
                        .amount(amount)
                        .splitType(splitType)
                        .build();
            case PERCENT:
             for(Split split:splitIntoUsers){
                 PercentSplit percentSplit = (PercentSplit) split;
                 Double per = percentSplit.getPercent();
                 split.setAmount((amount*per)/100);
             }
             return  PercentExpense.builder()
                     .expenseId(expenseId)
                     .expenseDesc(expenseDesc)
                     .createdDate(expenseDate)
                     .paidBy(userId)
                     .splitInto(splitIntoUsers)
                     .amount(amount)
                     .splitType(splitType)
                     .build();
        }
        return null;
    }


}
