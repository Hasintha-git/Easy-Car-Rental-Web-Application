package lk.easy.carrental.service.impl;

import lk.easy.carrental.dto.CarDto;
import lk.easy.carrental.dto.MainTainReturnDto;
import lk.easy.carrental.dto.MaintainDto;
import lk.easy.carrental.entity.Car;
import lk.easy.carrental.entity.Maintain;
import lk.easy.carrental.exception.ValidateException;
import lk.easy.carrental.repo.MaintainRepo;
import lk.easy.carrental.service.CarService;
import lk.easy.carrental.service.MaintainService;
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
public class MaintainServiceImpl implements MaintainService {
    @Autowired
    MaintainRepo maintainRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CarService carService;


    @Override
    public boolean addVehicle(MaintainDto maintainDto) {
            Maintain map = modelMapper.map(maintainDto, Maintain.class);
            maintainRepo.save(map);
            return true;

    }

    @Override
    public ArrayList<MaintainDto> getAllMaintainVehicle() {
        List<Maintain> all = maintainRepo.findAll();
        return modelMapper.map(all,new TypeToken<ArrayList<MaintainDto>>(){}.getType());


    }

    @Override
    public boolean releaseMaintain(Integer maintainId) {
        MaintainDto maintainDto = searchCar(maintainId);
        Maintain maintain = modelMapper.map(maintainDto, Maintain.class);
        maintainRepo.delete(maintain);
        return true;
    }

    @Override
    public MaintainDto searchCar(Integer maintainId) {
        Optional<Maintain> byId = maintainRepo.findById(maintainId);
        if (byId.isPresent()) {
            Maintain maintain = byId.get();
            return modelMapper.map(maintain, MaintainDto.class);
        }
        return null;
    }


    @Override
    public boolean updateMaintain(MaintainDto maintainDto) {

            Maintain map = modelMapper.map(maintainDto, Maintain.class);
            maintainRepo.save(map);
            return true;

    }

//    @Override
//    public ArrayList<MaintainDto> findByMaintainId(Integer maintainId) {
//        List<Maintain> maintainByMaintainId = maintainRepo.findMaintainByMaintainId(maintainId);
//        MaintainDto m1=new MaintainDto();
//        for (Maintain maintain1 : maintainByMaintainId) {
//            String vehicleNum = maintain1.getCar().getVehicleNum();
//
//        }
//        return modelMapper.map(m1,new TypeToken<ArrayList<MaintainDto>>(){}.getType());
//
//        }

    @Override
    public long countMaintainVehicle() {
        long count = maintainRepo.getCount();
        return count;
    }
}
