package lk.easy.carrental.repo;

import lk.easy.carrental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepo extends JpaRepository<Car,String > {
    List<Car> findCarByVehicleNum(String vehicleNum);
    List<Car> findCarByType(String type);
    List<Car> findCarByBrand(String brand);
    @Query(value = "select count(*) from Car ",nativeQuery = true)
    long getCount();
}
