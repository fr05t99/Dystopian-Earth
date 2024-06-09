package com.earth.dystopia.upi.service;

import com.earth.dystopia.upi.errors.IncorrectDetailsException;
import com.earth.dystopia.upi.pojo.UserProfile;
import com.earth.dystopia.upi.pojo.request.CreateUserRequest;
import com.earth.dystopia.upi.repository.UserRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.earth.dystopia.upi.pojo.enums.UserAccountStatus.ACTIVE;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService {

    UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public void createUser(CreateUserRequest createUserRequest) throws IncorrectDetailsException {
        userRepository.createUser(new UserProfile(createUserRequest.getPhoneNumber(), createUserRequest.getName(), ACTIVE));
    }
}
