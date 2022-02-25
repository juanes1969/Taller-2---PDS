package co.com.poli.serviceshowtimes.controller;

import co.com.poli.serviceshowtimes.entities.ShowTimes;
import co.com.poli.serviceshowtimes.helper.ResponseBuilder;
import co.com.poli.serviceshowtimes.model.Response;
import co.com.poli.serviceshowtimes.service.ShowTimeService;
import co.com.poli.serviceshowtimes.service.impl.ShowTimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/showtimes")
public class ShowTimesController {

    @Autowired
    private ShowTimeService showTimeService;

    @Autowired
    private ResponseBuilder builder;


    @GetMapping
    private Response findAll() {
        List<ShowTimes> usersList = showTimeService.findAllShowTimes();
        if (usersList.isEmpty()) {
            return builder.failedNotFound("Projects is empty");
        }
        return builder.successFind(usersList);
    }

    @PostMapping()
    public Response save(@Valid @RequestBody ShowTimes showTimes, BindingResult result) {
        if (result.hasErrors()) {
            return builder.failed(formatMessage(result));
        }
        showTimeService.createShowTimes(showTimes);
        return builder.success(showTimes);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id) {
        ShowTimes showTimes = showTimeService.findByMovieId(id);
        if (showTimes == null) {
            return builder.failed("El id no existe");
        } else {
            return builder.successFind(showTimes);
        }
    }

    @PutMapping("/{id}")
    public Response update(@PathVariable("id") Long id, @Valid @RequestBody ShowTimes showTimes, BindingResult result) {
        if (result.hasErrors()) {
            return builder.failed(formatMessage(result));
        }
        //showTimeService.updateShowTime(id, showTimes);
        return builder.success(showTimes);
    }

    private List<Map<String, String>> formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        return errors;
    }
}
