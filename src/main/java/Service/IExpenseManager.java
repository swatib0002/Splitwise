package Service;

import models.Expense;
import models.Split;
import models.SplitType;

import java.time.LocalDateTime;
import java.util.List;

public interface IExpenseManager {

    void addExpense(String userId, String expenseDesc, LocalDateTime expenseDate, List<Split> splitIntoUsers, SplitType splitType, Double amount);

    public Expense createExpense(String userId, String expenseDesc, LocalDateTime expenseDate, List<Split> splitIntoUsers, SplitType splitType, Double amount);
}
