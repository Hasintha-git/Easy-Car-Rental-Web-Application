package lk.easy.carrental.controller;
import lk.easy.carrental.dto.DriverDto;
import lk.easy.carrental.exception.NotFoundException;
import lk.easy.carrental.service.DriverService;
import lk.easy.carrental.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@RestController
@RequestMapping("/driving")
@CrossOrigin
public class DriverController {
    @Autowired
    DriverService driverService;

    @PostMapping (path = "/postDriver",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity saveCustomer(@RequestParam("driverId") String driverId, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("conatct") String contact) {
        Integer newDriverId;
        newDriverId= Integer.valueOf(driverId);
        System.out.println(newDriverId);
        DriverDto driverDto=new DriverDto(newDriverId,name,address,contact);
        boolean b = driverService.saveDriver(driverDto);
        System.out.println(b);
        return new ResponseEntity(new StandradResponse("201", "Done", b), HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity getDrivers(@RequestParam("driverId") String driverId, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("conatct") String contact){
        Integer newDriverId;
        System.out.println(driverId);
        newDriverId= Integer.valueOf(driverId);
        System.out.println(newDriverId);
        DriverDto driverDto=new DriverDto(newDriverId,name,address,contact);
        boolean b = driverService.updateDriver(driverDto);
        return new ResponseEntity(new StandradResponse("201", "Done", b), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getAllDrivers(){
        ArrayList<DriverDto> allDriver = driverService.getAllDriver();
        return new ResponseEntity(new StandradResponse("201", "Done", allDriver), HttpStatus.CREATED);

    }

    @DeleteMapping(path = "{driverId}")
    public ResponseEntity deleetDriver(@PathVariable String driverId){
        Integer newDriverId;
        newDriverId= Integer.valueOf(driverId);
        boolean b = driverService.deleteDriver(newDriverId);
        if (b){
            return new ResponseEntity(new StandradResponse("201", "Done", b), HttpStatus.CREATED);
        }else{
            return new ResponseEntity(new StandradResponse("401", "Done", new NotFoundException("Driver Not found")), HttpStatus.CREATED);
        }
    }

    @GetMapping(path = "/getCount")
    public ResponseEntity getCount(){
        long count = driverService.getCount();
        return new ResponseEntity(new StandradResponse("201", "Done", count), HttpStatus.CREATED);

    }

}
