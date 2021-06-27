package lk.easy.carrental.repo;

import lk.easy.carrental.entity.Customer;
import lk.easy.carrental.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver,Integer> {
    List<Driver> findDriverByName(String name);
    @Query(value = "select count(*) from Driver ",nativeQuery = true)
    long getCount();
}
