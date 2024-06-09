package com.earth.dystopia.upi.controllers;

import com.earth.dystopia.upi.errors.IncorrectDetailsException;
import com.earth.dystopia.upi.pojo.UserProfile;
import com.earth.dystopia.upi.pojo.request.CreateUserRequest;
import com.earth.dystopia.upi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<String> create(@RequestBody final CreateUserRequest request) throws IncorrectDetailsException {
        userService.createUser(request);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}
