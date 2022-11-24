package com.BusCompany.BookingOnline.controller;

import com.BusCompany.BookingOnline.dto.BookingRegisterDto;
import com.BusCompany.BookingOnline.dto.BookingResponseDto;

import com.BusCompany.BookingOnline.service.impl.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingServiceImpl bookingService;


    @PostMapping("/save")
    public ResponseEntity<BookingResponseDto> saveBooking(@RequestBody BookingRegisterDto bookingRegisterDto) {
        return bookingService.saveBooking(bookingRegisterDto);
    }

    @GetMapping("/getall")
    @ResponseBody
    public List<BookingResponseDto> getBookings(){

        return bookingService.getBookings();
    }

    @GetMapping("/get")
    @ResponseBody
    public BookingResponseDto getBooking(@RequestParam Integer id){
        return bookingService.getBooking(id);
    }

    @DeleteMapping("/delete")
    public void deleteById(Integer id){
        bookingService.deleteBooking(id);
    }

    @PatchMapping("/update")
    public void update (BookingRegisterDto bookingRegisterDto, Integer id){
        bookingService.updateBooking(bookingRegisterDto, id);
    }
}
