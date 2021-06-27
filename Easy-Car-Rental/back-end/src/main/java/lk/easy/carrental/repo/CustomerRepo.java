package lk.easy.carrental.repo;

import lk.easy.carrental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Integer > {
    List<Customer> findCustomerByCustomerId(Integer customerId);
    List<Customer> findCustomerByLogin_UserName(String customerName);
    @Query(value = "select count(*) from Customer ",nativeQuery = true)
    long getCount();
}
