package co.com.poli.servicebooking.client;

import co.com.poli.servicebooking.client.Hystri.ShowTimeClientFallbackHystrix;
import co.com.poli.servicebooking.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-showtimes", fallback = ShowTimeClientFallbackHystrix.class)
public interface ShowTimeClient {

    @GetMapping("/poli/v1/showtimes")
    Response findAll();

    @GetMapping("/poli/v1/showtimes/{id}")
    Response findById(@PathVariable("id") Long id);
}
