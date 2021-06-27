package lk.easy.carrental.controller;

import lk.easy.carrental.dto.CarDto;
import lk.easy.carrental.dto.MainTainReturnDto;
import lk.easy.carrental.dto.MaintainDto;
import lk.easy.carrental.entity.Car;
import lk.easy.carrental.entity.Maintain;
import lk.easy.carrental.exception.NotFoundException;
import lk.easy.carrental.service.CarService;
import lk.easy.carrental.service.MaintainService;
import lk.easy.carrental.util.StandradResponse;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/maintain")
@CrossOrigin
public class MaintainController {
    @Autowired
    MaintainService maintainService;

    @Autowired
    CarService carService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity  addMainTain(@RequestParam("maintainId") Integer maintainId, @RequestParam("status") String status, @RequestParam("date") String date, @RequestParam("vehicleNum") String vehicleNum) {
        CarDto carDto = carService.searchCar(vehicleNum);
        if (carDto==null) {
            return new ResponseEntity(new StandradResponse("400", "Done", new NotFoundException("Error type Car")), HttpStatus.CREATED);
        }
        Car car = modelMapper.map(carDto, Car.class);

        MaintainDto maintainDto = new MaintainDto(maintainId, status, date, car);
        boolean b = maintainService.addVehicle(maintainDto);
        if (b) {
            return new ResponseEntity(new StandradResponse("201", "Done", b), HttpStatus.CREATED);
        }
        return new ResponseEntity(new StandradResponse("201", "Failed", "Failed"), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity getAll(){
        ArrayList<MaintainDto> allMaintainVehicle = maintainService.getAllMaintainVehicle();
        return new ResponseEntity(new StandradResponse("201", "Done", allMaintainVehicle), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateMaintain(@RequestParam("maintainId") Integer maintainId, @RequestParam("status") String status, @RequestParam("date") String date, @RequestParam("vehicleNum") String vehicleNum){
        CarDto carDto = carService.searchCar(vehicleNum);
        Car car = modelMapper.map(carDto, Car.class);

        MaintainDto maintainDto = new MaintainDto(maintainId, status, date, car);
        boolean b = maintainService.addVehicle(maintainDto);
        if (b) {
        return new ResponseEntity(new StandradResponse("201", "Done", b), HttpStatus.CREATED);
    }
        return new ResponseEntity(new StandradResponse("201", "Failed", "Failed"), HttpStatus.CREATED);

    }

    @DeleteMapping
    public ResponseEntity release(@RequestParam("maintainId") Integer maintainId){
        boolean b = maintainService.releaseMaintain(maintainId);
        return new ResponseEntity(new StandradResponse("201", "Done", b), HttpStatus.CREATED);
    }

//    @GetMapping(path = "/findById")
//    public ResponseEntity findById(@RequestParam("maintainId") Integer maintainId){
//        ArrayList<MaintainDto> maintainDto = maintainService.findByMaintainId(maintainId);
//        return new ResponseEntity(new StandradResponse("201", "Done", maintainDto), HttpStatus.CREATED);
//    }

    @GetMapping(path = "/count")
    public ResponseEntity count(){
        long l = maintainService.countMaintainVehicle();
        return new ResponseEntity(new StandradResponse("201", "Done", l), HttpStatus.CREATED);
    }
}
