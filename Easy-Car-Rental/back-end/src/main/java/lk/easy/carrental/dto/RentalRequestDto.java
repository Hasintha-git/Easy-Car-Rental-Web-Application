package lk.easy.carrental.dto;

import lk.easy.carrental.entity.Car;
import lk.easy.carrental.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentalRequestDto {
    private Integer rentId;
    private String  pickupDate;
    private String  returnDate;
    private String driverOrNot;
    private String rentDuration;
    private Integer currentKM;
    private Customer customer;
    private Car car;


}
