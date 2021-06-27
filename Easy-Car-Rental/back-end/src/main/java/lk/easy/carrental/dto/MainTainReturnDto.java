package lk.easy.carrental.dto;

import lk.easy.carrental.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MainTainReturnDto{
    private Integer maintainId;
    private String status;
    private String date;
    private String vehicleNum;
}
