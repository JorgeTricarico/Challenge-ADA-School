package com.BusCompany.BookingOnline.service.impl;

import com.BusCompany.BookingOnline.model.Booking;
import com.BusCompany.BookingOnline.model.DbSequence;
import com.BusCompany.BookingOnline.service.ISequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SequenceGeneratorServiceImpl implements ISequenceGeneratorService {
        @Autowired
        private MongoOperations operations;

        public int getNextSequence(final String sequenceName) {
            // get the sequence number
            final Query q = new Query(Criteria.where("id").is(sequenceName));
            // increment the sequence number by 1
            // "sequence" should match the attribute value specified in DbSequence.java class.
            final Update u = new Update().inc("sequence", 1);
            // modify in document
            final DbSequence counter = operations.findAndModify(q, u,
                    FindAndModifyOptions.options().returnNew(true).upsert(true), DbSequence.class);

            return !Objects.isNull(counter) ? counter.getSequence() : 1;
    }
    //**********************************************
    public void onBeforeConvert(BeforeConvertEvent event) {
        Booking booking = (Booking) event.getSource();
        if (booking.getId() < 1) {
            booking.setId(getNextSequence(booking.SEQUENCE_NAME));
        }
    }
    //**********************************************
}
