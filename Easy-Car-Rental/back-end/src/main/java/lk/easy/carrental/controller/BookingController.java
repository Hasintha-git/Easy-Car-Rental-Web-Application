package lk.easy.carrental.controller;

import lk.easy.carrental.dto.*;
import lk.easy.carrental.entity.Booking;
import lk.easy.carrental.entity.Car;
import lk.easy.carrental.entity.Customer;
import lk.easy.carrental.entity.Driver;
import lk.easy.carrental.exception.NotFoundException;
import lk.easy.carrental.service.*;
import lk.easy.carrental.util.StandradResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/booking")
@CrossOrigin
public class BookingController {
    @Autowired
    CustomerService customerService;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CarService carService;

    @Autowired
    RentalRequestService rentalRequestService;

    @Autowired
    DriverService driverService;

    @Autowired
    BookingService bookingService;

    @PostMapping
    public ResponseEntity addRequest(@RequestParam("bookingId") Integer bookingId, @RequestParam("rentReqId") Integer rentReqId, @RequestParam("currentKm") Integer currentKm, @RequestParam("driverOrNot") String driverOrNot, @RequestParam("pickupDate") String pickupDate, @RequestParam("rentDuration") String rentDuration, @RequestParam("returnDate") String returnDate, @RequestParam("vehicleNum") String vehicleNum, @RequestParam("customerId") Integer customerId, @RequestParam("driverId") Integer driverId) {
        System.out.println(rentReqId);
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

        DriverDto driverDto = driverService.searchDriver(driverId);
        if (driverDto == null) {
            return new ResponseEntity(new StandradResponse("201", "Done", new NotFoundException("car not found")), HttpStatus.CREATED);
        }
        Driver driver = modelMapper.map(driverDto, Driver.class);
        BookingDto bookingDto = new BookingDto(bookingId, pickupDate, returnDate, driverOrNot, rentDuration, currentKm, customer, car, driver);
        boolean b = bookingService.sentBooking(bookingDto);
        if (b) {
            return new ResponseEntity(new StandradResponse("201", "Done", b), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(new StandradResponse("401", "fail", new NotFoundException("false")), HttpStatus.CREATED);
        }

    }

    @GetMapping
    public ResponseEntity getAllBooking() {
        ArrayList<BookingDto> allBooking = bookingService.getAllBooking();
        return new ResponseEntity(new StandradResponse("201", "Done", allBooking), HttpStatus.CREATED);

    }

    @GetMapping(path = "/getCount")
    public ResponseEntity getCount() {
        long l = bookingService.countBook();
        return new ResponseEntity(new StandradResponse("201", "Done", l), HttpStatus.CREATED);

    }


}
