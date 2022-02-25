package co.com.poli.users.serviceuser.service;

import co.com.poli.users.serviceuser.entities.Users;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {

    Users createUser(Users users);

    void deleteUser(Long id);

    List<Users> findAllUser();

    Users findById(Long id);
}
