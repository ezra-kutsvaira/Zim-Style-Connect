package com.zimstyleconnect.zimstyleconnect_backend.service;
import com.zimstyleconnect.zimstyleconnect_backend.entity.User;
import com.zimstyleconnect.zimstyleconnect_backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers (){
        return userRepository.findAll();
    }
}
