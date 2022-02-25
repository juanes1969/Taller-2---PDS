package co.com.poli.servicebooking.repository;

import co.com.poli.servicebooking.entities.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface BookingRepository extends JpaRepository<Bookings, Long> {
}
