package lk.easy.carrental.service;

import lk.easy.carrental.dto.CarDto;
import lk.easy.carrental.dto.MainTainReturnDto;
import lk.easy.carrental.dto.MaintainDto;

import java.util.ArrayList;

public interface MaintainService {
    boolean addVehicle(MaintainDto maintainDto);
    ArrayList<MaintainDto> getAllMaintainVehicle();
    boolean releaseMaintain(Integer maintainId);
    MaintainDto searchCar(Integer maintainId);
    boolean updateMaintain(MaintainDto maintainDto);
//    ArrayList<MaintainDto> findByMaintainId(Integer maintainId);
    long countMaintainVehicle();
}
