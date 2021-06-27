package lk.easy.carrental.dto;

import lk.easy.carrental.entity.Login;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto {
    private Integer customerId;
    private Login login;
    private String nicImg;
    private String drivingImg;
    private String address;
    private String contact;

}
