package lk.easy.carrental.service;

import lk.easy.carrental.dto.MaintainDto;
import lk.easy.carrental.dto.RentalRequestDto;

import java.util.ArrayList;

public interface RentalRequestService {
    boolean senRequest(RentalRequestDto rentalRequestDto);
    ArrayList<RentalRequestDto> getAllRequest();
    boolean removeReqAndBook(Integer rentReqId);
    RentalRequestDto searchReq(Integer rentReqId);
    boolean updateReq(RentalRequestDto rentalRequestDto);
    long countBook();
}
