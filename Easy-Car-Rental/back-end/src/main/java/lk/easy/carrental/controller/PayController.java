package lk.easy.carrental.controller;

import lk.easy.carrental.dto.PayDto;
import lk.easy.carrental.exception.NotFoundException;
import lk.easy.carrental.service.PayService;
import lk.easy.carrental.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/pay")
@CrossOrigin
public class PayController {
    @Autowired
    PayService payService;
    @PostMapping( consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity saveCustomer(@RequestParam("payId") Integer payId, @RequestParam("date") String date, @RequestParam("price") double price) {
        PayDto payDto = new PayDto(payId, date, price);
        boolean b = payService.savePay(payDto);
        if (b) {
            return new ResponseEntity(new StandradResponse("201", "Done", b), HttpStatus.CREATED);
        }else {
            return new ResponseEntity(new StandradResponse("401", "Failed", new NotFoundException("Something Went Erro")), HttpStatus.CREATED);
        }
    }

    @GetMapping
    public ResponseEntity getAllPayment(){
        ArrayList<PayDto> allPay = payService.getAllPay();
        return new ResponseEntity(new StandradResponse("201", "Done", allPay), HttpStatus.CREATED);

    }


    @GetMapping(path = "/getCount")
    public ResponseEntity getCount(){
        long count = payService.getCount();
        return new ResponseEntity(new StandradResponse("201", "Done", count), HttpStatus.CREATED);

    }
}
