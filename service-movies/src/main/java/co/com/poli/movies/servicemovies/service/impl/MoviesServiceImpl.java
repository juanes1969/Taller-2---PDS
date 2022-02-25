package co.com.poli.movies.servicemovies.service.impl;

import co.com.poli.movies.servicemovies.entities.Movies;
import co.com.poli.movies.servicemovies.repository.MoviesRepository;
import co.com.poli.movies.servicemovies.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    @Override
    public Movies createMovie(Movies movies) {
        return moviesRepository.save(movies);
    }

    @Override
    public List<Movies> findAllMovies() {
        return moviesRepository.findAll();
    }

    @Override
    public Movies findById(Long id) {
        return moviesRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMovies(Long id) {
        moviesRepository.deleteById(id);
    }
}
