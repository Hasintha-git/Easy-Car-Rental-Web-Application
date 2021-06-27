package lk.easy.carrental.controller;

import lk.easy.carrental.dto.CarDto;
import lk.easy.carrental.exception.NotFoundException;
import lk.easy.carrental.service.CarService;
import lk.easy.carrental.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController
@RequestMapping("/cars")
@CrossOrigin
public class CarController {

    @Autowired
    CarService carService;


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity fileUpload(@RequestPart("file") MultipartFile file, @RequestParam("vehicleNum") String vehicleNum, @RequestParam("brand") String brand, @RequestParam("type") String type, @RequestParam("passenger") String passenger, @RequestParam("color") String color, @RequestParam("priceForKm") int priceForKm, @RequestParam("transmission") String transmission, @RequestParam("fuel") String fuel, @RequestParam("dailyPrice") double dailyPrice, @RequestParam("monthPrice") double monthPrice, @RequestParam("freeKmForDay") int freeKmForDay, @RequestParam("freeKmForMonth") int freeKmForMonth, @RequestParam("currentKm") int currentKm) {
        String path = "";
        if (vehicleNum.trim().length() <= 0) {
            throw new NotFoundException("Vehicle Number cannot be empty");
        } else {
            try {
                String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
                System.out.println(file);
                File uploadsDir = new File(projectPath + "/uploads");
                uploadsDir.mkdir();
                path = String.valueOf(uploadsDir);
                file.transferTo(new File(path + "/" + file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            String img = path + "/" + file.getOriginalFilename();
            System.out.println(path);
            CarDto carDto = new CarDto(vehicleNum, brand, type, passenger, color, priceForKm, transmission, fuel, dailyPrice, monthPrice, freeKmForDay, freeKmForMonth, currentKm, img);

            System.out.println(file.getOriginalFilename());
            System.out.println(carDto);
            carService.saveCar(carDto);
            return new ResponseEntity(new StandradResponse("201", "Done", carDto), HttpStatus.CREATED);

        }
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity updateCar(@RequestPart("file") MultipartFile file, @RequestParam("vehicleNum") String vehicleNum, @RequestParam("brand") String brand, @RequestParam("type") String type, @RequestParam("passenger") String passenger, @RequestParam("color") String color, @RequestParam("priceForKm") int priceForKm, @RequestParam("transmission") String transmission, @RequestParam("fuel") String fuel, @RequestParam("dailyPrice") double dailyPrice, @RequestParam("monthPrice") double monthPrice, @RequestParam("freeKmForDay") int freeKmForDay, @RequestParam("freeKmForMonth") int freeKmForMonth, @RequestParam("currentKm") int currentKm) {
        String path = "";
        if (vehicleNum.trim().length() <= 0) {
            throw new NotFoundException("Vehicle Number cannot be empty");
        } else {
            try {
                String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
                System.out.println(file);
                File uploadsDir = new File(projectPath + "/uploads");
                uploadsDir.mkdir();
                path = String.valueOf(uploadsDir);
                file.transferTo(new File(path + "/" + file.getOriginalFilename()));


            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            String img = path + "/" + file.getOriginalFilename();
            System.out.println(path);
            CarDto carDto = new CarDto(vehicleNum, brand, type, passenger, color, priceForKm, transmission, fuel, dailyPrice, monthPrice, freeKmForDay, freeKmForMonth, currentKm, img);

            System.out.println(file.getOriginalFilename());
            System.out.println(carDto);
            boolean b = carService.updateCar(carDto);
            return new ResponseEntity(new StandradResponse("201", "Done", carDto), HttpStatus.CREATED);


        }
    }


    @GetMapping("/allcars")
    public ResponseEntity loadAllCars() {
        ArrayList<CarDto> allCars = carService.getAllCars();
        System.out.println(allCars);
        return new ResponseEntity(new StandradResponse("201", "Done", allCars), HttpStatus.CREATED);


    }

    @GetMapping(path = "/vehicleNum/{vehicleNum}")
    public ResponseEntity findCars(@PathVariable String vehicleNum) {
        ArrayList<CarDto> byCarNum = carService.findByCarNum(vehicleNum);
        if (byCarNum.isEmpty()) {
            return new ResponseEntity(new StandradResponse("401", "empty", new NotFoundException("customer Not Found")), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(new StandradResponse("201", "Done", byCarNum), HttpStatus.CREATED);

        }
    }

    @GetMapping(path = "/type/{type}")
    public ResponseEntity findType(@PathVariable String type) {
        ArrayList<CarDto> carType = carService.findCarType(type);
            return new ResponseEntity(new StandradResponse("201", "Done", carType), HttpStatus.CREATED);

    }
    @GetMapping(path = "/brand/{brand}")
    public ResponseEntity findBrand(@PathVariable String brand) {
        ArrayList<CarDto> carType = carService.findCarBrand(brand);
        if (carType.isEmpty()) {
            return new ResponseEntity(new StandradResponse("201", "Done", carType), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(new StandradResponse("401", "empty", new NotFoundException("customer Type Not Found")), HttpStatus.CREATED);
        }
    }
    @DeleteMapping(path = "{vehicleNum}")
    public ResponseEntity removeCar(@PathVariable String vehicleNum) {
        boolean b = carService.deleteCar(vehicleNum);
        if (b) {
            return new ResponseEntity(new StandradResponse("201", "Done", b), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(new StandradResponse("401", "empty", new NotFoundException("customer delete failed")), HttpStatus.CREATED);
        }
    }

    @GetMapping(path = "/getCount")
    public ResponseEntity getCount() {
        long l = carService.countCar();
        return new ResponseEntity(new StandradResponse("201", "Done", l), HttpStatus.CREATED);

    }


}
