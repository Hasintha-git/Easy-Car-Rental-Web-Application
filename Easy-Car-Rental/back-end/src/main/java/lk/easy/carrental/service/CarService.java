package lk.easy.carrental.service;

import lk.easy.carrental.dto.CarDto;

import java.util.ArrayList;

public interface CarService {
     boolean saveCar(CarDto carDto);
     ArrayList<CarDto> getAllCars();
     boolean deleteCar(String vehicleNum);
     CarDto searchCar(String vehicleNum);
     boolean updateCar(CarDto dto);
     ArrayList<CarDto> findByCarNum(String vehicleNum);
     ArrayList<CarDto> findCarType(String type);
     ArrayList<CarDto> findCarBrand(String brand);
     long countCar();
}
