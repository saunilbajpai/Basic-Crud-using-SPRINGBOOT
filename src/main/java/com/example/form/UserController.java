package com.example.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        userService.saveUser(user);
        return "User saved successfully!";
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deletebyId(id);
        return "User with name " + id + "is deleted" ;
    }

    @PutMapping("/update-email/{id}")
    public String updateUserEmail(@PathVariable Long id,@RequestBody String email){
        userService.updateUserEmail(id,email.replace("\"", ""));
        return "User's Email Updated Successfully";
    }

    @PutMapping("/update-tech/{id}")
    public String updateUserTech(@PathVariable Long id, @RequestBody String tech) {
        userService.updateUserTech(id, tech.replace("\"", ""));
        return "User's Tech Updated Successfully";
    }
    
}
