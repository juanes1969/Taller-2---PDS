package co.com.poli.servicebooking.client;

import co.com.poli.servicebooking.client.Hystri.CustomerClientFallbackHystrix;
import co.com.poli.servicebooking.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="service-movies", fallback = CustomerClientFallbackHystrix.class)
public interface MovieClient {

    @GetMapping("/poli/v1/movies")
    Response findAll();

    @GetMapping("/poli/v1/movies/{id}")
    Response findById(@PathVariable("id") Long id);
}
