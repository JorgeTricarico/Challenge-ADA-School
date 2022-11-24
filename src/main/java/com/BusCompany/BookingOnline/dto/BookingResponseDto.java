package com.BusCompany.BookingOnline.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BookingResponseDto {

    private Integer id;

    private String name;
    //private String email;
    private String origin;
    private String destination;

    private String departureDate;
    private String departureTime;

    private String duration;
}
