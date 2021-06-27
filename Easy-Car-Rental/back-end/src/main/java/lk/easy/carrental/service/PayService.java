package lk.easy.carrental.service;

import lk.easy.carrental.dto.DriverDto;
import lk.easy.carrental.dto.PayDto;

import java.util.ArrayList;

public interface PayService {
    boolean savePay(PayDto payDto);
    ArrayList<PayDto> getAllPay();
    long getCount();
}
