package com.earth.dystopia.upi.repository;

import com.earth.dystopia.upi.errors.IncorrectDetailsException;
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
}
