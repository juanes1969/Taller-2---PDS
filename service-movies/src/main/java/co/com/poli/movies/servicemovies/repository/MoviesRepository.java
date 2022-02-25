package co.com.poli.movies.servicemovies.repository;

import co.com.poli.movies.servicemovies.entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {
}
