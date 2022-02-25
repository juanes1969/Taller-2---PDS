package co.com.poli.servicebooking.controller;


import co.com.poli.servicebooking.entities.Bookings;
import co.com.poli.servicebooking.helper.ResponseBuilder;
import co.com.poli.servicebooking.model.Response;
import co.com.poli.servicebooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ResponseBuilder builder;

    @GetMapping
    private Response findAll() {
        List<Bookings> bookingsList = bookingService.findAllBookings();
        if (bookingsList.isEmpty()) {
            return builder.failedNotFound("Movies is empty");
        }
        return builder.successFind(bookingsList);
    }

    @PostMapping()
    public Response save(@Valid @RequestBody Bookings bookings, BindingResult result) {
        if (result.hasErrors()) {
            return builder.failed(formatMessage(result));
        }
        bookingService.createBooking(bookings);
        return builder.success(bookings);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id) {
        Bookings bookings = bookingService.findById(id);
        if (bookings == null) {
            return builder.failed("El id no existe");
        }
        return builder.successFind(bookings);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        Bookings bookings = bookingService.findById(id);
        if (bookings == null) {
            return builder.failed("El id no existe");
        } else {
            bookingService.deleteBooking(id);
            return builder.successFind(bookings);
        }
    }

    @GetMapping("user/{userId}")
    public Response findByUserId(@PathVariable("userId") Long userId) {
        Bookings bookings = bookingService.findByUserId(userId);
        if (bookings == null) {
            return builder.failed("El id no existe");
        } else {
            return builder.successFind(bookings);
        }
    }


    private List<Map<String, String>> formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        return errors;
    }

}
