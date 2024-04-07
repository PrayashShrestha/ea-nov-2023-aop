package edu.miu.springaop.controller;

import edu.miu.springaop.service.UserService;
import edu.miu.springaop.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User save(User user){
        return userService.save(user);
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }
}
