package lk.easy.carrental.dto;

import lk.easy.carrental.entity.Car;
import lk.easy.carrental.entity.Customer;
import lk.easy.carrental.entity.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDto {
    private Integer bookingId;
//    private Integer rentId;
    private String  pickupDate;
    private String  returnDate;
    private String driverOrNot;
    private String rentDuration;
    private Integer currentKM;
    private Customer customer;
    private Car car;
    private Driver driver;


}
