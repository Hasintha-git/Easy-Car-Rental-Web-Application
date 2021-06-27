package lk.easy.carrental.repo;

import lk.easy.carrental.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepo extends JpaRepository<Booking,Integer> {
    @Query(value = "select count(*) from Booking ",nativeQuery = true)
    long getCount();
}
