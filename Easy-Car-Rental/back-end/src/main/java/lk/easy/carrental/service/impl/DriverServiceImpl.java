package lk.easy.carrental.service.impl;

import lk.easy.carrental.dto.CustomerDto;
import lk.easy.carrental.dto.DriverDto;
import lk.easy.carrental.entity.Customer;
import lk.easy.carrental.entity.Driver;
import lk.easy.carrental.exception.ValidateException;
import lk.easy.carrental.repo.DriverRepo;
import lk.easy.carrental.service.DriverService;
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
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public boolean saveDriver(DriverDto driverDto) {
        if (driverRepo.existsById(driverDto.getDriverId())) {
            throw new ValidateException("driver Already in ..");
        }else{
            Driver map = modelMapper.map(driverDto, Driver.class);
            driverRepo.save(map);
            return true;
        }
    }

    @Override
    public boolean updateDriver(DriverDto driverDto) {
        if (driverRepo.existsById(driverDto.getDriverId())) {
            Driver map = modelMapper.map(driverDto, Driver.class);
            driverRepo.save(map);
            return true;
        }else{
            throw new ValidateException("Wrong Driver");
        }
    }

    @Override
    public ArrayList<DriverDto> getAllDriver() {
        List<Driver> all = driverRepo.findAll();
        return modelMapper.map(all,new TypeToken<ArrayList<DriverDto>>(){}.getType());
    }

    @Override
    public boolean deleteDriver(Integer driverId) {
        DriverDto driverDto = searchDriver(driverId);
        Driver map = modelMapper.map(driverDto, Driver.class);
        driverRepo.delete(map);
        return true;
    }

    @Override
    public DriverDto searchDriver(Integer driverId) {
        Optional<Driver> byId = driverRepo.findById(driverId);
        if (byId.isPresent()) {
            Driver driver = byId.get();
            DriverDto map = modelMapper.map(driver, DriverDto.class);
            return map;
        }
        return null;
    }

    @Override
    public ArrayList<DriverDto> findDriverName(String name) {
        List<Driver> driverByName = driverRepo.findDriverByName(name);
        return modelMapper.map(driverByName,new TypeToken<ArrayList<DriverDto>>(){}.getType());

    }

    @Override
    public long getCount() {
        long count = driverRepo.getCount();
        return count;
    }
}
