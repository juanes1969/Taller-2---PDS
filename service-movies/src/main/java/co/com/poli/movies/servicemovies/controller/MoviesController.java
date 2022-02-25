package co.com.poli.movies.servicemovies.controller;

import co.com.poli.movies.servicemovies.entities.Movies;
import co.com.poli.movies.servicemovies.helper.ResponseBuilder;
import co.com.poli.movies.servicemovies.model.Response;
import co.com.poli.movies.servicemovies.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @Autowired
    private ResponseBuilder builder;


    @GetMapping
    private Response findAll() {
        List<Movies> moviesList = moviesService.findAllMovies();
        if (moviesList.isEmpty()) {
            return builder.failedNotFound("Movies is empty");
        }
        return builder.successFind(moviesList);
    }

    @PostMapping()
    public Response save(@Valid @RequestBody Movies movies, BindingResult result) {
        if (result.hasErrors()) {
            return builder.failed(formatMessage(result));
        }
        moviesService.createMovie(movies);
        return builder.success(movies);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id) {
        Movies movies = moviesService.findById(id);
        if (movies == null) {
            return builder.failed("El id no existe");
        }
        return builder.successFind(movies);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        Movies movies = moviesService.findById(id);
        if (movies == null) {
            return builder.failed("El id no existe");
        } else {
            moviesService.deleteMovies(id);
            return builder.successFind(movies);
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
