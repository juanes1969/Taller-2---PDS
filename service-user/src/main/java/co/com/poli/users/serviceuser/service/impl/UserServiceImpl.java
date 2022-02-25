package co.com.poli.users.serviceuser.service.impl;


import co.com.poli.users.serviceuser.entities.Users;
import co.com.poli.users.serviceuser.repository.UserRepository;
import co.com.poli.users.serviceuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users createUser(Users users) {
        return userRepository.save(users);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Users> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Users findById(Long id) {

        return userRepository.findById(id).orElse(null);
    }
}
