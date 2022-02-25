package co.com.poli.servicebooking.model;

import lombok.Data;

import java.util.Date;

@Data
public class ShowTime {
    private Long id;
    private Date date;
    private Long movieId;
}
