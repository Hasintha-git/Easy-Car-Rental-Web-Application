package lk.easy.carrental.repo;

import lk.easy.carrental.entity.Customer;
import lk.easy.carrental.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginServiceRepo extends JpaRepository<Login,String > {
    List<Login> findLoginByUserName(String userName);
}
