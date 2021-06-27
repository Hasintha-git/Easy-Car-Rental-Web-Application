package lk.easy.carrental.service;

import lk.easy.carrental.dto.CarDto;
import lk.easy.carrental.dto.CustomerDto;

import java.util.ArrayList;

public interface CustomerService {
    boolean saveCustomer(CustomerDto customerDto);
    boolean updateCustomer(CustomerDto customerDto);
    ArrayList<CustomerDto> getAllCustomer();
    boolean deleteCustomer(Integer customerId);
    CustomerDto searchCustomer(Integer customerId);
    ArrayList<CustomerDto> findByCustomerId(Integer customerId);
    ArrayList<CustomerDto> findCustomerName(String customerName);
    long getCount();
}
