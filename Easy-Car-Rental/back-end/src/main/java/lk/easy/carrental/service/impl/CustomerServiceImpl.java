package lk.easy.carrental.service.impl;

import lk.easy.carrental.dto.CarDto;
import lk.easy.carrental.dto.CustomerDto;
import lk.easy.carrental.entity.Car;
import lk.easy.carrental.entity.Customer;
import lk.easy.carrental.exception.ValidateException;
import lk.easy.carrental.repo.CarRepo;
import lk.easy.carrental.repo.CustomerRepo;
import lk.easy.carrental.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean saveCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
         customerRepo.save(customer);
        return true;
    }

    @Override
    public boolean updateCustomer(CustomerDto customerDto) {
        if (customerRepo.existsById(customerDto.getCustomerId())) {
            Customer c = modelMapper.map(customerDto, Customer.class);
            customerRepo.save(c);

        }else {
            throw  new ValidateException("Not Found");
        }
        return true;
    }

    @Override
    public ArrayList<CustomerDto> getAllCustomer() {
        List<Customer> all = customerRepo.findAll();
        return modelMapper.map(all,new TypeToken<ArrayList<CustomerDto>>(){}.getType());
    }

    @Override
    public boolean deleteCustomer(Integer customerId) {
        if (customerRepo.existsById(customerId)) {
            CustomerDto customerDto = searchCustomer(customerId);
            Customer c = modelMapper.map(customerDto, Customer.class);
            customerRepo.delete(c);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public CustomerDto searchCustomer(Integer customerId) {
        Optional<Customer> cust = customerRepo.findById(customerId);
        if (cust.isPresent()) {
            Customer customer = cust.get();
            CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
            return customerDto;
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDto> findByCustomerId(Integer customerId) {
        if (customerRepo.existsById(customerId)) {
            List<Customer> custId = customerRepo.findCustomerByCustomerId(customerId);
            return modelMapper.map(custId,new TypeToken<ArrayList<CustomerDto>>(){}.getType());
        }else{
            throw new ValidateException("Customer ID Can't find");
        }
    }

    @Override
    public ArrayList<CustomerDto> findCustomerName(String customerName) {
            List<Customer> custName = customerRepo.findCustomerByLogin_UserName(customerName);
            return modelMapper.map(custName,new TypeToken<ArrayList<CustomerDto>>(){}.getType());

    }



    @Override
    public long getCount() {
        long count = customerRepo.getCount();
        return count;
    }
}
