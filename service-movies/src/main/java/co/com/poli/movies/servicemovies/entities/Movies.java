package co.com.poli.movies.servicemovies.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;
    @NotEmpty(message = "El title no debe estar vacio")
    @Column(name = "title")
    private String title;
    @NotEmpty(message = "El director no debe estar vacio")
    @Column(name = "director")
    private String director;
    @Range(min = 1, max = 5, message = "El valor debe ser en entre 1 o 5")
    @Column(name = "rating")
    private int rating;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movies movies = (Movies) o;
        return Objects.equals(id, movies.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
