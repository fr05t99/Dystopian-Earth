package com.earth.dystopia.upi.pojo;

import com.earth.dystopia.upi.pojo.enums.TransactionRole;
import lombok.Data;

@Data
public class BankTransaction {
    TransactionRole transactionRole;

    Long amount;

    Long timestamp;
}
