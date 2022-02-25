package co.com.poli.serviceshowtimes.entities;


import co.com.poli.serviceshowtimes.model.Movies;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Getter
@Setter
@Entity
@Table(name = "showtimes")
public class ShowTimes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;
    @JsonFormat(pattern = "dd-mm-yyy")
    @Column(name = "date")
    private Date date;
    @Column(name = "movie_id")
    private Long movieId;
    @Transient
    private Movies movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowTimes showtimes = (ShowTimes) o;
        return Objects.equals(id, showtimes.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
