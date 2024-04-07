package edu.miu.springaop.service;

import edu.miu.springaop.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> getAll();



}
