package co.com.poli.servicebooking.client.Hystri;

import co.com.poli.servicebooking.client.UserClient;
import co.com.poli.servicebooking.helper.ResponseBuilder;
import co.com.poli.servicebooking.model.Movies;
import co.com.poli.servicebooking.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserClientFallBackHystrix implements UserClient {

    private final ResponseBuilder builder;

    @Override
    public Response findAll() {
        return builder.successFind(new Movies());
    }

    @Override
    public Response findById(Long id) {
        return builder.successFind(new Movies());
    }
}
