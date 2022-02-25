package co.com.poli.servicebooking.service;

import co.com.poli.servicebooking.entities.Bookings;

import java.util.List;

public interface BookingService {

    Bookings createBooking(Bookings bookings);

    List<Bookings> findAllBookings();

    Bookings findById(Long id);

    void deleteBooking(Long id);

    Bookings findByUserId(Long userId);

}
