package co.com.poli.serviceshowtimes.service;

import co.com.poli.serviceshowtimes.entities.ShowTimes;

import java.util.List;


public interface ShowTimeService {

    ShowTimes createShowTimes(ShowTimes times);

    List<ShowTimes> findAllShowTimes();

    ShowTimes findByMovieId(Long id);

    //ShowTimes updateShowTime(Long id, ShowTimes showTimes);

}
