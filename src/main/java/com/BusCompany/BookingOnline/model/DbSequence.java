package com.BusCompany.BookingOnline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

@Document(collection = "db_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DbSequence {


    @Id
    private String  id;
    @Field("sequence_number")
    private Integer sequence;

}
