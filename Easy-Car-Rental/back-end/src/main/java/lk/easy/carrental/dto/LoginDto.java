package lk.easy.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginDto {
    private String userName;
    private String password;
    private String role;
    private String email;
    private String nic;
    private String address;
}
