package com.BusCompany.BookingOnline.service;

import com.BusCompany.BookingOnline.dto.BookingRegisterDto;
import com.BusCompany.BookingOnline.dto.BookingResponseDto;
import com.BusCompany.BookingOnline.model.Booking;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBookingService {

    public List<BookingResponseDto> getBookings();

    public BookingResponseDto getBooking(Integer id);

    public ResponseEntity saveBooking(BookingRegisterDto bookingRegisterDto);

    public void deleteBooking(Integer id);

    public void updateBooking(BookingRegisterDto booking, Integer id);



}
