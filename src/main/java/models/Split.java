package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Split {

    private String userId;
    double amount;

    Split(String user){
        this.userId = user;
    }
}
