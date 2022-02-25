package co.com.poli.servicebooking.client;

import co.com.poli.servicebooking.client.Hystri.UserClientFallBackHystrix;
import co.com.poli.servicebooking.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-user", fallback = UserClientFallBackHystrix.class)
public interface UserClient {

    @GetMapping("/poli/v1/users")
    Response findAll();

    @GetMapping("/poli/v1/users/{id}")
    Response findById(@PathVariable("id") Long id);
}
