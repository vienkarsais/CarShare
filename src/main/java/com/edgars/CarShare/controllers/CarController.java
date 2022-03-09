package com.edgars.CarShare.controllers;

import com.edgars.CarShare.models.Car;
import com.edgars.CarShare.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    private CarService carServiceImpl;
    @Autowired
    public CarController(CarService carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping("/car-list")
    public String showAllCars(Model model){
        List<Car> carList = carServiceImpl.showAllCars();
        model.addAttribute("carList", carList);
        return "car-list";
    }

    @GetMapping("/car-form")
    public String showCarForm(Car car, Model model){
        model.addAttribute("car", car);
        return "add-car";
    }
    @PostMapping("/add-car")
    public String saveCar(@ModelAttribute("car") Car car){
        carServiceImpl.addCar(car);
        return "redirect:/car/car-list";
    }


}
