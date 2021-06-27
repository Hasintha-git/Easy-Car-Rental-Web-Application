package lk.easy.carrental.service.impl;

import lk.easy.carrental.dto.CustomerDto;
import lk.easy.carrental.dto.LoginDto;
import lk.easy.carrental.entity.Customer;
import lk.easy.carrental.entity.Login;
import lk.easy.carrental.exception.ValidateException;
import lk.easy.carrental.repo.LoginServiceRepo;
import lk.easy.carrental.service.LoginService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginServiceRepo loginServiceRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public boolean saveLogin(LoginDto loginDto) {
        if (loginServiceRepo.existsById(loginDto.getUserName())) {
            return false;
        }else {
            Login login = modelMapper.map(loginDto, Login.class);
            Login save = loginServiceRepo.save(login);
            return true;
        }
    }

    @Override
    public boolean updateLogin(LoginDto loginDto) {
        if (loginServiceRepo.existsById(loginDto.getUserName())) {
            Login map = modelMapper.map(loginDto, Login.class);
            Login save = loginServiceRepo.save(map);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public ArrayList<LoginDto> findByUserName(String userName) {

        if (loginServiceRepo.existsById(userName)) {
            List<Login> loginByUserName = loginServiceRepo.findLoginByUserName(userName);
            return  modelMapper.map(loginByUserName,new TypeToken<ArrayList<LoginDto>>(){}.getType());
        }else{
            throw new ValidateException("User Name Can't find");
        }

    }

    @Override
    public LoginDto searchLogin(String userName) {
        Optional<Login> byId = loginServiceRepo.findById(userName);
        if (byId.isPresent()) {
            Login login = byId.get();
            LoginDto map = modelMapper.map(login, LoginDto.class);
            return map;
        }
        return null;
    }
}
