import Service.IUserService;
import Service.Impl.ExpenseManagerImpl;
import Service.Impl.UserServiceImpl;
import models.EqualSplit;
import models.PercentSplit;
import models.Split;
import models.SplitType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUser("swati", "Swati.bansal", 326527634);
        userService.createUser("Sneha", "Sneha.bansal", 652763455);
        userService.createUser("neha", "neha.bansal", 25653455);
        int i = 1;
        Scanner scanner = new Scanner(System.in);
        while(i<4){
            System.out.println("Enter expense Details:");
            String expenseDesc = scanner.nextLine();
            String splitType = scanner.nextLine();
            Double amount = scanner.nextDouble();
            List<Split> splits = new ArrayList<>();
            ExpenseManagerImpl expenseManager = new ExpenseManagerImpl();
            if(splitType == "PERCENT"){
                splits.add(new PercentSplit("326527634",60));
                splits.add(new PercentSplit("652763455",40));
                expenseManager.createExpense("326527634",expenseDesc,LocalDateTime.now(),splits,SplitType.PERCENT,amount);
            }
            else if(splitType == "EQUAL"){
                splits.add(new EqualSplit("652763455"));
                splits.add(new EqualSplit("25653455"));
                expenseManager.createExpense("652763455",expenseDesc,LocalDateTime.now(),splits,SplitType.EQUAL,amount);
            }
            i--;
        }
        System.out.println("show balance:");
        userService.showBalance("326527634");
    }
}
