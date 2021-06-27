package lk.easy.carrental.controller;


import lk.easy.carrental.dto.LoginDto;
import lk.easy.carrental.service.LoginService;
import lk.easy.carrental.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    //    public ResponseEntity fileUpload(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("role") String role, @RequestParam("email") String email, @RequestParam("nic") int nic, @RequestParam("address") String address) {
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity addLogin(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("role") String role, @RequestParam("email") String email, @RequestParam("nic") String nic, @RequestParam("address") String address) {
        int length = password.length();
        if (length>=5) {
            LoginDto loginDto = new LoginDto(userName, password, role, email, nic, address);
            boolean b = loginService.saveLogin(loginDto);
            System.out.println(userName + "" + password);
            return new ResponseEntity(new StandradResponse("201", "Done", b), HttpStatus.CREATED);

        }else{
            return new ResponseEntity(new StandradResponse("201", "Done", "Password Not Safe"), HttpStatus.CREATED);
        }

    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity updateLogin(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("role") String role, @RequestParam("email") String email, @RequestParam("nic") String nic, @RequestParam("address") String address) {

        LoginDto loginDto = new LoginDto(userName, password, role, email, nic, address);
        boolean b = loginService.updateLogin(loginDto);
        System.out.println(userName + "" + password);
        return new ResponseEntity(new StandradResponse("201", "Done", b), HttpStatus.CREATED);

    }

    @GetMapping(path = "{userName}")
    public ResponseEntity checkSignIn(@PathVariable String userName){
        ArrayList<LoginDto> byUserName = loginService.findByUserName(userName);
        if (byUserName.isEmpty()) {
            return new ResponseEntity(new StandradResponse("400", "Done", byUserName), HttpStatus.CREATED);
        }
        return new ResponseEntity(new StandradResponse("201", "Done", byUserName), HttpStatus.CREATED);

    }

}
