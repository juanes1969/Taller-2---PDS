package co.com.poli.movies.servicemovies.service;

import co.com.poli.movies.servicemovies.entities.Movies;

import java.util.List;

public interface MoviesService {

    Movies createMovie (Movies movies);
    List<Movies> findAllMovies();
    Movies findById(Long id);
    void deleteMovies(Long id);

}
