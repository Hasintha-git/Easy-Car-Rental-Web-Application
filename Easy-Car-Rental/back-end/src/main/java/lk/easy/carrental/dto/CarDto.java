package lk.easy.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarDto  {
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

}

