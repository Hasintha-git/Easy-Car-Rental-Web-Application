package lk.easy.carrental.repo;

import lk.easy.carrental.entity.RentalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RentalRequestRepo extends JpaRepository<RentalRequest,Integer> {
    @Query(value = "select count(*) from RentalRequest ",nativeQuery = true)
    long getCount();
}
