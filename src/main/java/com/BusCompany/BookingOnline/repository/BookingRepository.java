package com.BusCompany.BookingOnline.repository;
import com.BusCompany.BookingOnline.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {
    public Optional<Booking> findById(Integer id);
    public void deleteById(Integer id);
}
