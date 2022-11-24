package com.BusCompany.BookingOnline.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Data
@Document(collection = "Books")
public class Booking {

    @Transient
    public static final String SEQUENCE_NAME = "booking_sequence";

    @Id
    private Integer id;

    private String name;

    private String email;

    private String origin;

    private String destination;

    private String departureDate;

    private String departureTime;

    private String duration;
}
