package lk.easy.carrental.service;

import lk.easy.carrental.dto.CustomerDto;
import lk.easy.carrental.dto.DriverDto;

import java.util.ArrayList;

public interface DriverService {
    boolean saveDriver(DriverDto driverDto);
    boolean updateDriver(DriverDto driverDto);
    ArrayList<DriverDto> getAllDriver();
    boolean deleteDriver(Integer driverId);
    DriverDto searchDriver(Integer driverId);
    ArrayList<DriverDto> findDriverName(String name);
    long getCount();
}
