package com.sahan.appone.service;

import com.sahan.appone.dao.CarRepository;
import com.sahan.appone.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    /**
     * Get all the cars
     * @return
     */
    public List<Car> getAll(){
       return carRepository.findAll();
    }

    /**
     * Get a car details by id
     * @param id
     * @return
     */
    public Car getACar(int id){
        if(carRepository.findById(id).isPresent()) {
            return carRepository.findById(id).get();
        } else {
            return null;
        }
    }

    /**
     * Adding a car
     * @param car
     * @return
     */
    public int addCar(Car car){
        if(car != null) {
            carRepository.save(car);
            return 1;
        } else {
           return -1;
        }
    }

}
