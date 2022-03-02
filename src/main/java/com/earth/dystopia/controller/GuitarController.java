package com.earth.dystopia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "guitar")
public class GuitarController {
    
    @RequestMapping(method = RequestMethod.GET, value = "/testApi")
    public ResponseEntity<String> testApi() {
        return new ResponseEntity<>("Hi", HttpStatus.OK);
    }
}
