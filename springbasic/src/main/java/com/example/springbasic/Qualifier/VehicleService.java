package com.example.springbasic.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VehicleService {

    @Autowired
    @Qualifier(value = "HondaBean")
    private Vehicle vehicle;

    @Autowired
    @Qualifier(value = "Bycycle")
    private Bycycle bycycle;

    public void service(){
        vehicle.start();
        vehicle.stop();
    }
    public void byservice(){
        bycycle.start();
        bycycle.stop();
    }
}
