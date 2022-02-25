package co.com.poli.serviceshowtimes.client;

import co.com.poli.serviceshowtimes.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="service-movies", fallback = CustomerClientFallbackHystrix.class)
public interface MoviesClient {

    @GetMapping("/poli/v1/movies")
    Response findAll();

    @GetMapping("/poli/v1/movies/{id}")
    Response findById(@PathVariable("id") Long id);
}
