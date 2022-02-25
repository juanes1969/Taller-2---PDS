package co.com.poli.servicebooking.entities;


import co.com.poli.servicebooking.model.Movies;
import co.com.poli.servicebooking.model.ShowTime;
import co.com.poli.servicebooking.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Transient
    private User user;
    @Column(name = "show_time_id", nullable = false)
    private Long showTimeId;
    @Transient
    private ShowTime showTime;
    @Column(name = "movie_id")
    private Long movieId;
    @Transient
    private Movies movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bookings bookings = (Bookings) o;
        return Objects.equals(id, bookings.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
