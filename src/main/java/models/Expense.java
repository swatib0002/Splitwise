package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Expense {

    String expenseId;
    String expenseDesc;
    LocalDateTime createdDate;
    String paidBy;
    List<Split> splitInto;
    Double amount;
    Enum splitType;

}
