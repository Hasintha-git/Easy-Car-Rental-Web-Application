package lk.easy.carrental.service.impl;

import lk.easy.carrental.dto.BookingDto;
import lk.easy.carrental.entity.Booking;
import lk.easy.carrental.entity.RentalRequest;
import lk.easy.carrental.repo.BookingRepo;
import lk.easy.carrental.service.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    BookingRepo bookingRepo;
    @Override
    public boolean sentBooking(BookingDto bookingDto) {
        Booking booking = modelMapper.map(bookingDto, Booking.class);
        bookingRepo.save(booking);
        return true;
    }

    @Override
    public ArrayList<BookingDto> getAllBooking() {
        List<Booking> all = bookingRepo.findAll();
        return modelMapper.map(all,new TypeToken<ArrayList<BookingDto>>(){}.getType());
    }

    @Override
    public long countBook() {
        long count = bookingRepo.getCount();
        return count;
    }
}
