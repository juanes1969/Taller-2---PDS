package co.com.poli.servicebooking.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    private Integer code;
    private Object data;
}
