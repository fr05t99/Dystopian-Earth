package com.earth.dystopia.upi.pojo;

import com.earth.dystopia.upi.pojo.enums.BankName;
import lombok.Data;

import java.util.List;

@Data
public class BankAccount {
    BankName bankName;

    Long accountNumber;

    Boolean isPrimary;

    Long balance;

    List<BankTransaction> bankTransactions;
}
