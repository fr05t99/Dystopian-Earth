package com.earth.dystopia.guitars.controller;

import com.earth.dystopia.guitars.pojo.Guitar;
import com.earth.dystopia.guitars.pojo.GuitarSpec;
import com.earth.dystopia.guitars.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "guitars")
public class GuitarController {

    @Autowired
    GuitarService guitarService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ResponseEntity<String> add(@RequestBody final Guitar guitar) {
        guitarService.addGuitar(guitar);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/search")
    public ResponseEntity<List<Guitar>> search(@RequestBody final GuitarSpec spec) {
        return new ResponseEntity<>(guitarService.search(spec), HttpStatus.OK);
    }

}
