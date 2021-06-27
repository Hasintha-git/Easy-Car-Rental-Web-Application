package lk.easy.carrental.repo;

import lk.easy.carrental.entity.Car;
import lk.easy.carrental.entity.Maintain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaintainRepo extends JpaRepository<Maintain,Integer> {
//    List<Maintain> findMaintainByCar(String vehicleNum);
    @Query(value = "select count(*) from Maintain ",nativeQuery = true)
    long getCount();



}
