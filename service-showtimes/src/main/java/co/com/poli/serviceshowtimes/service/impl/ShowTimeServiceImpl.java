package co.com.poli.serviceshowtimes.service.impl;

import co.com.poli.serviceshowtimes.client.MoviesClient;
import co.com.poli.serviceshowtimes.entities.ShowTimes;
import co.com.poli.serviceshowtimes.model.Movies;
import co.com.poli.serviceshowtimes.repository.ShowTimeRepository;
import co.com.poli.serviceshowtimes.service.ShowTimeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowTimeServiceImpl implements ShowTimeService {

    private final ShowTimeRepository showTimeRepository;
    private final MoviesClient moviesClient;

    @Override
    public ShowTimes createShowTimes(ShowTimes times) {
        return showTimeRepository.save(times);
    }

    /*@Override
    public ShowTimes updateShowTime(Long id, ShowTimes showTimes) {
        ShowTimes showTimes1 = showTimeRepository.findById(id).orElse(null);

        showTimes1.setDate(showTimes.getDate());
        showTimes1.setMovieId(showTimes.getMovieId());


        return showTimeRepository.updateShowTimes(id, showTimes);
    }*/

    @Override
    public List<ShowTimes> findAllShowTimes() {
        List<ShowTimes> showTimes = showTimeRepository.findAll();
        showTimes.stream().map(movie -> {
            return movie = findByMovieId(movie.getMovieId());
        }).collect(Collectors.toList());
        return showTimeRepository.findAll();
    }

    @Override
    public ShowTimes findByMovieId(Long id) {

        ShowTimes invoice = showTimeRepository.findByMovieId(id);
        ModelMapper modelMapper = new ModelMapper();
        Movies movies = modelMapper.
                map(moviesClient.findById(invoice.getMovieId()).getData(), Movies.class);
        invoice.setMovies(movies);

        return showTimeRepository.findByMovieId(id);
    }

}
