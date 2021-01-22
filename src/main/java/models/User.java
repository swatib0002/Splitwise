package models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class User {

    String  userId;
    String name;
    @NonNull
    String email;
    long mobileNumber;
    List<Expense> expense;

    public User(String name, @NonNull String email, long mobileNumber){
      userId = mobileNumber+"";
      this.name = name;
      this.email = email;
      this.mobileNumber = mobileNumber;
      expense = new ArrayList<>();
    }

}
