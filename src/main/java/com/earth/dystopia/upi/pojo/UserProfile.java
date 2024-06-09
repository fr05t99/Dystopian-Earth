package com.earth.dystopia.upi.pojo;

import com.earth.dystopia.upi.pojo.enums.UserAccountStatus;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Data
@Getter
public class UserProfile {
    @NonNull
    String phoneNumber;

    @NonNull
    String name;

    @NonNull
    UserAccountStatus userAccountStatus;

    List<BankAccount> bankAccounts;
}
