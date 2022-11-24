package com.BusCompany.BookingOnline.util;

import com.BusCompany.BookingOnline.dto.BookingRegisterDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ValidationBooking {

    public ResponseEntity<?> validationBooking(BookingRegisterDto booking) {

            if (booking.getName()== null || booking.getName().isBlank()){
                return  new ResponseEntity("Name cannot be blank or null or must be correct format" ,HttpStatus.BAD_REQUEST);
            }
            if (booking.getEmail()== null || booking.getEmail().isBlank() || !booking.getEmail().contains("@")){

                return  new ResponseEntity("Email cannot be blank or null or must be correct format", HttpStatus.BAD_REQUEST);
            }
            if ( booking.getOrigin()== null || booking.getOrigin().isBlank()) {
                return  new ResponseEntity("Origin cannot be blank or null", HttpStatus.BAD_REQUEST);
            }
            if ( booking.getDestination()== null || booking.getDestination().isBlank()) {
                return  new ResponseEntity("Destination cannot be blank or null", HttpStatus.BAD_REQUEST);
            }
            if (booking.getDepartureDate()== null || booking.getDepartureDate().isBlank()) {
                return  new ResponseEntity("Departure Date cannot be blank or null", HttpStatus.BAD_REQUEST);
            }
            if (booking.getDepartureTime()== null || booking.getDepartureTime().isBlank()) {
                return  new ResponseEntity("Departure Time cannot be blank or null", HttpStatus.BAD_REQUEST );
            }
            if ( booking.getDuration()== null || booking.getDuration().isBlank()) {
                return  new ResponseEntity("Duration cannot be blank or null", HttpStatus.BAD_REQUEST);
            }

        return null;
    }
}
