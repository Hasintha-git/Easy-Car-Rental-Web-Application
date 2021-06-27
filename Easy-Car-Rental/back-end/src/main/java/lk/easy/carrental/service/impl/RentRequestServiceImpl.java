package lk.easy.carrental.service.impl;

import lk.easy.carrental.dto.RentalRequestDto;
import lk.easy.carrental.entity.RentalRequest;
import lk.easy.carrental.exception.ValidateException;
import lk.easy.carrental.repo.RentalRequestRepo;
import lk.easy.carrental.service.RentalRequestService;
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
public class RentRequestServiceImpl implements RentalRequestService {
    @Autowired
    RentalRequestRepo rentalRequestRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public boolean senRequest(RentalRequestDto rentalRequestDto) {
        RentalRequest map = modelMapper.map(rentalRequestDto, RentalRequest.class);
        rentalRequestRepo.save(map);
        return true;

    }

    @Override
    public ArrayList<RentalRequestDto> getAllRequest() {
        List<RentalRequest> all = rentalRequestRepo.findAll();
        return modelMapper.map(all, new TypeToken<ArrayList<RentalRequestDto>>() {
        }.getType());
    }

    @Override
    public boolean removeReqAndBook(Integer rentReqId) {
        System.out.println(rentReqId);
        RentalRequestDto rentalRequestDto = searchReq(rentReqId);
        System.out.println(rentalRequestDto.toString());
        RentalRequest map = modelMapper.map(rentalRequestDto, RentalRequest.class);
        rentalRequestRepo.delete(map);
        return true;

    }

    @Override
    public RentalRequestDto searchReq(Integer rentReqId) {
        Optional<RentalRequest> byId = rentalRequestRepo.findById(rentReqId);
        if (byId.isPresent()) {
            RentalRequest rentalRequest = byId.get();
            RentalRequestDto map = modelMapper.map(rentalRequest, RentalRequestDto.class);
            return map;
        }
        return null;
    }

    @Override
    public boolean updateReq(RentalRequestDto rentalRequestDto) {
        RentalRequest map = modelMapper.map(rentalRequestDto, RentalRequest.class);
        rentalRequestRepo.save(map);
        return true;
    }

    @Override
    public long countBook() {
        long count = rentalRequestRepo.getCount();
        return count;
    }
}
