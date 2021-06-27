package lk.easy.carrental.service;


import lk.easy.carrental.dto.CustomerDto;
import lk.easy.carrental.dto.LoginDto;

import java.util.ArrayList;

public interface LoginService {
    boolean saveLogin(LoginDto loginDto);
    boolean updateLogin(LoginDto loginDto);
    ArrayList<LoginDto> findByUserName(String userName);
    LoginDto searchLogin(String userName);
}
