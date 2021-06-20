package com.sahan.appone.controller;

import com.sahan.appone.model.Car;
import com.sahan.appone.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAllCars(){
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Object getCarById(@PathVariable("id") int id){
        if(carService.getACar(id) != null) {
            return carService.getACar(id);
        } else {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", "INVALID CAR ID");
            return errorMessage;
        }
    }

    @PostMapping
    public int addCar(@RequestBody Car car){

        return carService.addCar(car);

    }



}
