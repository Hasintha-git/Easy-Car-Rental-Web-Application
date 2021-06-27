package lk.easy.carrental.controller;

import lk.easy.carrental.dto.CustomerDto;
import lk.easy.carrental.dto.LoginDto;
import lk.easy.carrental.entity.Login;
import lk.easy.carrental.exception.NotFoundException;
import lk.easy.carrental.service.CustomerService;
import lk.easy.carrental.service.LoginService;
import lk.easy.carrental.util.StandradResponse;
import org.modelmapper.ModelMapper;
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
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    LoginService loginService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity saveCustomer(@RequestPart("nicImg") MultipartFile nicImg, @RequestPart("drivingImg") MultipartFile drivingImg, @RequestParam("customerId") Integer customerId, @RequestParam("customerName") String customerName, @RequestParam("address") String address, @RequestParam("contact") String contact) {
        String path="" ;
        LoginDto loginDto = loginService.searchLogin(customerName);
        System.out.println(loginDto);
        if (loginDto==null) {
            return new ResponseEntity(new StandradResponse("400", "Done", new NotFoundException("You Must Sign Up First")), HttpStatus.CREATED);
        }
        Login login = modelMapper.map(loginDto, Login.class);
        System.out.println("login data-----"+login);
        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            System.out.println(nicImg);
            System.out.println(drivingImg);
            File uploadsDir = new File(projectPath + "/uploads");
            uploadsDir.mkdir();
             path=String.valueOf(uploadsDir);

            nicImg.transferTo(new File(path + "/" + nicImg.getOriginalFilename()));
            drivingImg.transferTo(new File(path + "/" + drivingImg.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            String nicImagePath = path + "/" + nicImg.getOriginalFilename();
            String drivingImgPath = path + "/" + drivingImg.getOriginalFilename();
            System.out.println(nicImagePath);
            System.out.println(drivingImgPath);
            CustomerDto customerDto = new CustomerDto(customerId, login, nicImagePath, drivingImgPath, address, contact);
        System.out.println(customerDto+"customer dto issss");
            boolean b = customerService.saveCustomer(customerDto);
        System.out.println(b);
            return new ResponseEntity(new StandradResponse("201", "Done", b), HttpStatus.CREATED);


    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity updateCustomer(@RequestPart("nicImg") MultipartFile nicImg, @RequestPart("drivingImg") MultipartFile drivingImg, @RequestParam("customerId") Integer customerId, @RequestParam("customerName") String customerName, @RequestParam("address") String address, @RequestParam("contact") String contact) {
        LoginDto loginDto = loginService.searchLogin(customerName);
        if (loginDto==null) {
            return new ResponseEntity(new StandradResponse("400", "Done", new NotFoundException("You Must Sign Up First")), HttpStatus.CREATED);
        }
        Login login = modelMapper.map(loginDto, Login.class);
        String path = null;
        try {
                String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
                System.out.println(nicImg);
                System.out.println(drivingImg);
                File uploadsDir = new File(projectPath + "/uploads");
                uploadsDir.mkdir();
                 path = String.valueOf(uploadsDir);

                nicImg.transferTo(new File(path + "/" + nicImg.getOriginalFilename()));
                drivingImg.transferTo(new File(path + "/" + drivingImg.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
                String nicImagePath = path + "/" + nicImg.getOriginalFilename();
                String drivingImgPath = path + "/" + drivingImg.getOriginalFilename();
                System.out.println(nicImagePath);
                System.out.println(drivingImgPath);
                CustomerDto customerDto = new CustomerDto(customerId, login, nicImagePath, drivingImgPath, address, contact);
                boolean b = customerService.updateCustomer(customerDto);
                if (b) {
                    return new ResponseEntity(new StandradResponse("200", "Done", b), HttpStatus.CREATED);

                } else {
                    return new ResponseEntity(new StandradResponse("400", "Done", new NotFoundException("You Must Sign Up First")), HttpStatus.CREATED);

                }

    }



    @GetMapping(path = "/getAll")
    public ArrayList<CustomerDto>loadAllCustomer(){
        ArrayList<CustomerDto> allCustomer = customerService.getAllCustomer();
        return allCustomer;
    }

    @GetMapping(path = "/findId",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ArrayList<CustomerDto>findById(@RequestParam ("customerId") Integer customerId){
        return customerService.findByCustomerId(customerId);
    }

    @GetMapping(path = "/findName/{userName}")
    public ResponseEntity findByName(@PathVariable String userName){
        ArrayList<CustomerDto> customerName = customerService.findCustomerName(userName);
            return new ResponseEntity(new StandradResponse("201", "Done", customerName), HttpStatus.CREATED);
    }
    @DeleteMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String removeCar(@RequestParam ("customerId") Integer customerId){
        boolean b = customerService.deleteCustomer(customerId);
        return "success";
    }

    @GetMapping(path = "/getCount")
    public ResponseEntity getCount(){
        long count = customerService.getCount();
        return new ResponseEntity(new StandradResponse("201", "Done", count), HttpStatus.CREATED);

    }

}
