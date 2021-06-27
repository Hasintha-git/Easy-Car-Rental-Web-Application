package lk.easy.carrental.service.impl;

import lk.easy.carrental.dto.CarDto;
import lk.easy.carrental.entity.Car;
import lk.easy.carrental.exception.ValidateException;
import lk.easy.carrental.repo.CarRepo;
import lk.easy.carrental.service.CarService;
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
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepo carRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean saveCar(CarDto carDto){
        if (carRepo.existsById(carDto.getVehicleNum())) {
            throw  new ValidateException("Car Already Exist");
        }
        Car car = modelMapper.map(carDto, Car.class);
        carRepo.save(car);
        return true;
    }
    @Override
    public ArrayList<CarDto>getAllCars(){
        List<Car> all = carRepo.findAll();
        return modelMapper.map(all,new TypeToken<ArrayList<CarDto>>(){}.getType());
    }
    @Override
    public boolean deleteCar(String vehicleNum){
        CarDto carDto = searchCar(vehicleNum);
        Car car = modelMapper.map(carDto, Car.class);
        carRepo.delete(car);
        return true;
    }
    @Override
    public CarDto searchCar(String vehicleNum) {
        Optional<Car> car = carRepo.findById(vehicleNum);
        if (car.isPresent()) {
            Car c = car.get();
            CarDto carDto = modelMapper.map(c, CarDto.class);
            return carDto;
        }
        return null;
    }

    @Override
    public boolean updateCar(CarDto dto) {
        if (carRepo.existsById(dto.getVehicleNum())) {
            Car car = modelMapper.map(dto, Car.class);
            carRepo.save(car);

        }else {
            throw  new ValidateException("Not Found");
        }
        return true;
    }

    @Override
    public ArrayList<CarDto> findByCarNum(String vehicleNum){
        List<Car> carByName = carRepo.findCarByVehicleNum(vehicleNum);
        return modelMapper.map(carByName,new TypeToken<ArrayList<CarDto>>(){}.getType());
    }
    @Override
    public ArrayList<CarDto> findCarType(String type){
        List<Car> carByType = carRepo.findCarByType(type);
        return modelMapper.map(carByType,new TypeToken<ArrayList<CarDto>>(){}.getType());
    }

    @Override
    public ArrayList<CarDto> findCarBrand(String brand) {
        List<Car> carByBrand = carRepo.findCarByBrand(brand);
        return modelMapper.map(carByBrand, new TypeToken<ArrayList<CarDto>>() {}.getType());

    }

    @Override
    public long countCar() {
        long count = carRepo.getCount();
        return count;
    }
}
