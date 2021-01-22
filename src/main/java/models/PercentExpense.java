package models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public class PercentExpense extends Expense{
    public PercentExpense(String expenseId, String expenseDesc, LocalDateTime createdDate, String paidBy, List<Split> splitInto, Double amount, Enum splitType) {
        super(expenseId, expenseDesc, createdDate, paidBy, splitInto, amount, splitType);
    }
}
