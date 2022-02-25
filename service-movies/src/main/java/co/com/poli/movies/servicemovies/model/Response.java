package co.com.poli.movies.servicemovies.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    private Integer code;
    private Object data;
}
