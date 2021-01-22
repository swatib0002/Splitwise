package models;

import java.time.LocalDateTime;
import java.util.List;

public class EqualExpense extends Expense{
    public EqualExpense(String expenseId, String expenseDesc, LocalDateTime createdDate, String paidBy, List<Split> splitInto, Double amount, Enum splitType) {
        super(expenseId, expenseDesc, createdDate, paidBy, splitInto, amount, splitType);
    }


}
