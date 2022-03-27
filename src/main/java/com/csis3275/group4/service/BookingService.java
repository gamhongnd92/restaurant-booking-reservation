package com.csis3275.group4.service;

import com.csis3275.group4.entity.Booking;
import com.csis3275.group4.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingService implements IService<Booking> {

    @Autowired
    BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void add(Booking obj) {
        this.bookingRepository.insert(obj);
    }

    @Override
    public void delete(String Id) {
        this.bookingRepository.deleteById(Id);
    }

    @Override
    public void update(String Id, Booking obj) {
        Booking updateBooking = this.findById(Id);

        if (updateBooking != null) {
            updateBooking.setBookingTime(obj.getBookingTime());
            updateBooking.setBookingDate(obj.getBookingDate());
            updateBooking.setServices(obj.getServices());
            updateBooking.setTables(obj.getTables());
            updateBooking.setCustomer(obj.getCustomer());
            updateBooking.setStaff(obj.getStaff());

            this.bookingRepository.save(updateBooking);
        }
    }

    @Override
    public List<Booking> getAll() {
        return this.bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> getById(UUID Id) {
        return Optional.empty();
    }

    public Booking findById(String id) {
        return this.bookingRepository.findAll().stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }
}