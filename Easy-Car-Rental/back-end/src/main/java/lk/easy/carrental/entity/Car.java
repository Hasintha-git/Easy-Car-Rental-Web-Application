package lk.easy.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    @Id
    private String vehicleNum;
    private String brand;
    private String type;
    private String passenger;
    private String color;
    private double priceForKm;
    private String transmission;
    private String fuel;
    private double dailyPrice;
    private double monthPrice;
    private int kmForDay;
    private int kmForMonth;
    private int currentKm;
    private String img;

//    @OneToMany(mappedBy = "Car",cascade = CascadeType.ALL)
//    private List<Maintain>maintain;

}

