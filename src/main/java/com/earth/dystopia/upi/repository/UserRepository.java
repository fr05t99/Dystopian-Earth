package com.earth.dystopia.upi.repository;

import com.earth.dystopia.upi.errors.IncorrectDetailsException;
import com.earth.dystopia.upi.pojo.BankAccount;
import com.earth.dystopia.upi.pojo.UserProfile;
import com.earth.dystopia.upi.pojo.request.CreateUserRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    List<UserProfile> userProfileDB;

    public UserRepository() {
        userProfileDB = new ArrayList<>();
    }

    private void validateUserCreation(UserProfile userProfile) throws IncorrectDetailsException {
        for (UserProfile existingUser : userProfileDB) {
            if (existingUser.getPhoneNumber().equals(userProfile.getPhoneNumber())) {
                throw new IncorrectDetailsException("Phone number already exists");
            }
        }
    }

    public void createUser(UserProfile userProfile) throws IncorrectDetailsException {
        validateUserCreation(userProfile);
        userProfileDB.add(userProfile);
    }

    public UserProfile getUser(String phoneNumber) {
        for (UserProfile userProfile : userProfileDB) {
            if (userProfile.getPhoneNumber().equals(phoneNumber)) {
                return userProfile;
            }
        }
        return null;
    }

    public UserProfile updateUser(String phoneNumber, UserProfile updateUserProfile) {
        for (int i = 0;i < userProfileDB.size();i++) {
            if (userProfileDB.get(i).getPhoneNumber().equals(phoneNumber)) {
                userProfileDB.set(i, updateUserProfile);
            }
        }
        return null;
    }

    public boolean accountDoesExist(BankAccount bankAccount) {
        for (UserProfile userProfile : userProfileDB) {
            if (userProfile.getBankAccounts() != null) {
                for (BankAccount bankAcc : userProfile.getBankAccounts()) {
                    if (bankAcc.getAccountNumber().equals(bankAccount.getAccountNumber())
                            && bankAcc.getBankName().equals(bankAccount.getBankName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
