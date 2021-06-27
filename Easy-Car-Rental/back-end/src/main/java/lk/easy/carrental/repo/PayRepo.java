package lk.easy.carrental.repo;

import lk.easy.carrental.entity.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PayRepo extends JpaRepository<Pay,Integer> {
    @Query(value = "select count(*) from Pay ",nativeQuery = true)
    long getCount();
}
