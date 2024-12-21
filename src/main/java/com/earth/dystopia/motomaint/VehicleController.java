package com.earth.dystopia.motomaint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

    @GetMapping("/vehicles")
    public String getVehicles() {
        return "List of vehicles";
    }
}

