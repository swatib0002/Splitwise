package Repository;

import javafx.util.Pair;
import models.Expense;
import models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

   public static Map<String, User> userMap = new HashMap<>();

   public static Map<String, Map<String, Double>> userBalanceMap = new HashMap<>();
}
