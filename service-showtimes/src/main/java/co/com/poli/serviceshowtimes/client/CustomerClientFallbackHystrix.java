package co.com.poli.serviceshowtimes.client;

import co.com.poli.serviceshowtimes.helper.ResponseBuilder;
import co.com.poli.serviceshowtimes.model.Movies;
import co.com.poli.serviceshowtimes.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerClientFallbackHystrix implements MoviesClient {

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
