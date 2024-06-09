package com.earth.dystopia.upi.pojo;

import com.earth.dystopia.upi.pojo.enums.BankName;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BankAccount {
    BankName bankName;

    Long accountNumber;

    Boolean isPrimary;

    Long balance;

    List<BankTransaction> bankTransactions;
}
