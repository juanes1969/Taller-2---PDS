package co.com.poli.serviceshowtimes.repository;


import co.com.poli.serviceshowtimes.entities.ShowTimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowTimeRepository extends JpaRepository<ShowTimes,Long> {

    ShowTimes findByMovieId(Long id);

    //ShowTimes updateShowTimes(Long id, ShowTimes showTimes);
}
