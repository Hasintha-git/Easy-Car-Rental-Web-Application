package lk.easy.carrental.service;

import lk.easy.carrental.dto.BookingDto;
import lk.easy.carrental.dto.RentalRequestDto;

import java.util.ArrayList;

public interface BookingService {
    boolean sentBooking(BookingDto bookingDto);
    ArrayList<BookingDto> getAllBooking();
//    boolean delete(Integer bookingId);
//    BookingService searchBook(Integer bookingId);
//    boolean updateBook(BookingService bookingDto);
    long countBook();
}
