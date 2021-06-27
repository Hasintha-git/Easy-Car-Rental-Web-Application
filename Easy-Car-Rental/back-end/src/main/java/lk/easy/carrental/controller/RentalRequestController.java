package lk.easy.carrental.controller;

import lk.easy.carrental.dto.CarDto;
import lk.easy.carrental.dto.CustomerDto;
import lk.easy.carrental.dto.RentalRequestDto;
import lk.easy.carrental.entity.Car;
import lk.easy.carrental.entity.Customer;
import lk.easy.carrental.exception.NotFoundException;
import lk.easy.carrental.service.CarService;
import lk.easy.carrental.service.CustomerService;
import lk.easy.carrental.service.RentalRequestService;
import lk.easy.carrental.util.StandradResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/rentalReq")
@CrossOrigin
public class RentalRequestController {
    @Autowired
    CustomerService customerService;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CarService carService;

    @Autowired
    RentalRequestService rentalRequestService;

    @PostMapping
    public ResponseEntity addRequest(@RequestParam("rentReqId") Integer rentReqId, @RequestParam("currentKm") Integer currentKm, @RequestParam("driverOrNot") String driverOrNot, @RequestParam("pickupDate") String pickupDate, @RequestParam("rentDuration") String rentDuration, @RequestParam("returnDate") String returnDate, @RequestParam("vehicleNum") String vehicleNum, @RequestParam("customerId") Integer customerId) {

        CustomerDto customerDto = customerService.searchCustomer(customerId);
        if (customerDto == null) {
            return new ResponseEntity(new StandradResponse("201", "Done", new NotFoundException("customer not found")), HttpStatus.CREATED);
        }
        Customer customer = modelMapper.map(customerDto, Customer.class);
        System.out.println("Customer is aaaaaaa" + customer);
        CarDto carDto = carService.searchCar(vehicleNum);
        if (carDto == null) {
            return new ResponseEntity(new StandradResponse("201", "Done", new NotFoundException("car not found")), HttpStatus.CREATED);

        }
        Car car = modelMapper.map(carDto, Car.class);
        System.out.println("car is aaaaaa" + car);

        RentalRequestDto rentalRequestDto = new RentalRequestDto(rentReqId, pickupDate, returnDate, driverOrNot, rentDuration, currentKm, customer, car);
        boolean b = rentalRequestService.senRequest(rentalRequestDto);
        return new ResponseEntity(new StandradResponse("201", "Done", b), HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity updateRequest(@RequestParam("rentReqId") Integer rentReqId, @RequestParam("currentKm") Integer currentKm, @RequestParam("driverOrNot") String driverOrNot, @RequestParam("pickupDate") String pickupDate, @RequestParam("rentDuration") String rentDuration, @RequestParam("returnDate") String returnDate, @RequestParam("vehicleNum") String vehicleNum, @RequestParam("customerId") Integer customerId) {
        CustomerDto customerDto = customerService.searchCustomer(customerId);
        if (customerDto == null) {
            return new ResponseEntity(new StandradResponse("201", "Done", new NotFoundException("customer not found")), HttpStatus.CREATED);

        }
        Customer customer = modelMapper.map(customerDto, Customer.class);
        System.out.println("Customer is aaaaaaa" + customer);
        CarDto carDto = carService.searchCar(vehicleNum);
        if (carDto == null) {
            return new ResponseEntity(new StandradResponse("201", "Done", new NotFoundException("car not found")), HttpStatus.CREATED);

        }
        Car car = modelMapper.map(carDto, Car.class);
        System.out.println("car is aaaaaa" + car);

        RentalRequestDto rentalRequestDto = new RentalRequestDto(rentReqId, pickupDate, returnDate, driverOrNot, rentDuration, currentKm, customer, car);
        boolean b = rentalRequestService.updateReq(rentalRequestDto);
        return new ResponseEntity(new StandradResponse("201", "Done", b), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity findAllReq() {
        ArrayList<RentalRequestDto> allRequest = rentalRequestService.getAllRequest();
        return new ResponseEntity(new StandradResponse("201", "Done", allRequest), HttpStatus.CREATED);

    }

    @DeleteMapping(path = "{rentReqId}")
    public ResponseEntity deleteReq(@PathVariable String rentReqId) {
        System.out.println(rentReqId);
        Integer newRentId = Integer.valueOf(rentReqId);
        boolean b = rentalRequestService.removeReqAndBook(newRentId);
        if (b) {
            return new ResponseEntity(new StandradResponse("201", "Done", b), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(new StandradResponse("401", "empty", new NotFoundException("customer delete failed")), HttpStatus.CREATED);
        }
    }

    @GetMapping(path = "/getCount")
    public ResponseEntity getCount() {
        long count = rentalRequestService.countBook();
        return new ResponseEntity(new StandradResponse("201", "Done", count), HttpStatus.CREATED);
    }

}
