package co.com.poli.servicebooking.service.impl;

import co.com.poli.servicebooking.client.MovieClient;
import co.com.poli.servicebooking.client.ShowTimeClient;
import co.com.poli.servicebooking.client.UserClient;
import co.com.poli.servicebooking.entities.Bookings;
import co.com.poli.servicebooking.model.Movies;
import co.com.poli.servicebooking.model.ShowTime;
import co.com.poli.servicebooking.model.User;
import co.com.poli.servicebooking.repository.BookingRepository;
import co.com.poli.servicebooking.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private MovieClient movieClient;

    @Autowired
    private ShowTimeClient showTimeClient;

    @Autowired
    private UserClient userClient;

    @Override
    public Bookings createBooking(Bookings bookings) {
        return bookingRepository.save(bookings);
    }

    @Override
    public List<Bookings> findAllBookings() {
        List<Bookings> bookings = bookingRepository.findAll();
        bookings.stream().map(movie -> {
            return movie = findById(movie.getUserId());
        }).collect(Collectors.toList());

        bookings.stream().map(movie -> {
            return movie = findById(movie.getShowTimeId());
        }).collect(Collectors.toList());

        bookings.stream().map(movie -> {
            return movie = findById(movie.getMovieId());
        }).collect(Collectors.toList());

        return bookingRepository.findAll();
    }

    @Override
    public Bookings findById(Long id) {

        Bookings invoice = bookingRepository.findById(id).orElse(null);
        ModelMapper modelMapper = new ModelMapper();
        Movies movies = modelMapper.
                map(movieClient.findById(invoice.getMovieId()).getData(), Movies.class);
        invoice.setMovies(movies);

        Bookings invoices = bookingRepository.findById(id).orElse(null);
        ModelMapper modelMappers = new ModelMapper();
        User user = modelMappers.
                map(userClient.findById(invoices.getUserId()).getData(), User.class);
        invoices.setUser(user);

        Bookings invoic = bookingRepository.findById(id).orElse(null);
        ModelMapper modelMappe = new ModelMapper();
        ShowTime showTime = modelMappe.
                map(showTimeClient.findById(invoic.getShowTimeId()).getData(), ShowTime.class);
        invoic.setShowTime(showTime);

        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public Bookings findByUserId(Long userId) {
        return null;
    }
}
