package lk.easy.carrental.service.impl;

import lk.easy.carrental.dto.PayDto;
import lk.easy.carrental.entity.Pay;
import lk.easy.carrental.repo.PayRepo;
import lk.easy.carrental.service.PayService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PayServiceImpl implements PayService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PayRepo payRepo;
    @Override
    public boolean savePay(PayDto payDto) {
        Pay map = modelMapper.map(payDto, Pay.class);
        payRepo.save(map);
        return true;
    }

    @Override
    public ArrayList<PayDto> getAllPay() {
        List<Pay> all = payRepo.findAll();
        return modelMapper.map(all,new TypeToken<ArrayList<PayDto>>(){}.getType());
    }

    @Override
    public long getCount() {
        long count = payRepo.getCount();
        return count;
    }
}
