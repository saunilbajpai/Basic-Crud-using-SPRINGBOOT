package com.example.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deletebyId(Long id){
        userRepository.deleteById(id);
    }

    public void updateUserTech(Long id ,String tech){
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setTech(tech);
            userRepository.save(user);
        }
    }

    public void updateUserEmail(Long id, String email){
        User user = userRepository.findById(id).orElse(null);
        if(user != null){
            user.setEmail(email);
            userRepository.save(user);
        }
    }
}
