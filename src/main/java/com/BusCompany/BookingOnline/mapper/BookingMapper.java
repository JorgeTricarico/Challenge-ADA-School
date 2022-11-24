package com.BusCompany.BookingOnline.mapper;

import com.BusCompany.BookingOnline.dto.BookingRegisterDto;
import com.BusCompany.BookingOnline.dto.BookingResponseDto;
import com.BusCompany.BookingOnline.model.Booking;
import org.springframework.stereotype.Component;


@Component
public class BookingMapper {

    public BookingResponseDto bookingToBookingResponseDto(Booking booking){
        if (booking == null){
            return null;
        }

        BookingResponseDto bookingResponseDto = new BookingResponseDto();
        bookingResponseDto.setId(booking.getId());
        bookingResponseDto.setName(booking.getName());
        bookingResponseDto.setOrigin(booking.getOrigin());
        bookingResponseDto.setDestination(booking.getDestination());
        bookingResponseDto.setDepartureDate(booking.getDepartureDate().toString());
        bookingResponseDto.setDuration(booking.getDuration());

        return bookingResponseDto;
    }

    public Booking bookingRegisterDtoToBooking(BookingRegisterDto bookingRegisterDto) {
        if (bookingRegisterDto == null) {
            return null;
        }
        Booking booking = new Booking();
        booking.setId(bookingRegisterDto.getId());
        booking.setName(bookingRegisterDto.getName());
        booking.setOrigin(bookingRegisterDto.getOrigin());
        booking.setDestination(bookingRegisterDto.getDestination());
        booking.setDepartureDate(bookingRegisterDto.getDepartureDate());
        booking.setDepartureTime(bookingRegisterDto.getDepartureTime());
        booking.setDuration(bookingRegisterDto.getDuration());

        return booking;
    }



}
