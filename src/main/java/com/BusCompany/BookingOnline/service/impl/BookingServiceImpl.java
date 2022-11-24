package com.BusCompany.BookingOnline.service.impl;

import com.BusCompany.BookingOnline.dto.BookingRegisterDto;
import com.BusCompany.BookingOnline.dto.BookingResponseDto;
import com.BusCompany.BookingOnline.mapper.BookingMapper;
import com.BusCompany.BookingOnline.model.Booking;
import com.BusCompany.BookingOnline.repository.BookingRepository;
import com.BusCompany.BookingOnline.service.IBookingService;
import com.BusCompany.BookingOnline.util.ValidationBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.BusCompany.BookingOnline.model.Booking.SEQUENCE_NAME;

@Service
public class BookingServiceImpl implements IBookingService {

    @Autowired
    private BookingRepository bookRepo;

    @Autowired
    private SequenceGeneratorServiceImpl service;

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private ValidationBooking validation;

    /*@Autowired
    private BookingMapper mapper;*/

    @Override
    public List<BookingResponseDto> getBookings() {
        Optional<List<Booking>> OptionalListBooking = Optional.ofNullable(bookRepo.findAll());

        List<BookingResponseDto> listBookingResponseDto = new ArrayList<>();

        if (OptionalListBooking.isPresent()){
            List<Booking> listBooking = OptionalListBooking.get();

            for (Booking booking : listBooking) {
                listBookingResponseDto.add(bookingMapper.bookingToBookingResponseDto(booking));
            }
            return listBookingResponseDto;
        }
        return listBookingResponseDto;

    }

    @Override
    public BookingResponseDto getBooking(Integer id) {
        Optional<Booking> booking = bookRepo.findById(id);
        if (booking.isPresent()){
            BookingResponseDto response = bookingMapper.bookingToBookingResponseDto(booking.get());
            return response;
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public ResponseEntity saveBooking(BookingRegisterDto bookingRegisterDto) {

                ResponseEntity valid = validation.validationBooking(bookingRegisterDto);
                if (valid != null){
                    return valid;
                }

                bookingRegisterDto.setId(service.getNextSequence(SEQUENCE_NAME));
                Booking booking = bookingMapper.bookingRegisterDtoToBooking(bookingRegisterDto);
                bookRepo.save(booking);
                return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @Override
    public void deleteBooking(Integer id) {
        bookRepo.deleteById(id);
    }

    @Override
    public void updateBooking(BookingRegisterDto bookingRegisterDto, Integer id) {
        bookingRegisterDto.setId(id);
        validation.validationBooking(bookingRegisterDto);
        Booking booking = bookingMapper.bookingRegisterDtoToBooking(bookingRegisterDto);
        bookRepo.save(booking);
    }


}
