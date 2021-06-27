package lk.easy.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentalRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer rentReqId;
    private String  pickupDate;
    private String returnDate;
    private String driverOrNot;
    private String rentDuration;
    private Integer currentKM;

    @ManyToOne
    @JoinColumn(name = "vehicleNum",referencedColumnName = "vehicleNum")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "customerId",referencedColumnName = "customerId")
    private Customer customer;

}
