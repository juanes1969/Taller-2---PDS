package co.com.poli.users.serviceuser.controller;

import co.com.poli.users.serviceuser.entities.Users;
import co.com.poli.users.serviceuser.helper.ResponseBuilder;
import co.com.poli.users.serviceuser.model.Response;
import co.com.poli.users.serviceuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResponseBuilder builder;

    @GetMapping
    private Response findAll() {
        List<Users> usersList = userService.findAllUser();
        if (usersList.isEmpty()) {
            return builder.failedNotFound("Projects is empty");
        }
        return builder.successFind(usersList);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id) {
        Users users = userService.findById(id);
        if (users == null) {
            return builder.failed("El id no existe");
        }
        return builder.successFind(users);
    }

    @PostMapping()
    public Response save(@Valid @RequestBody Users users, BindingResult result) {
        if (result.hasErrors()) {
            return builder.failed(formatMessage(result));
        }
        userService.createUser(users);
        return builder.success(users);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        Users users = userService.findById(id);
        if (users == null) {
            return builder.failed("El id no existe");
        } else {
            userService.deleteUser(id);
            return builder.successDeleted(users);
        }
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
