package io.dreamstudio.demo.service;

import io.dreamstudio.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ricky Fung
 */
@Service
public class UserService {

    public User getUserByName(String name) {
        User user = new User();
        user.setId(15L);
        user.setName(name);
        user.setAge(29);
        return user;
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>(3);
        for (int i=0; i<3; i++) {
            list.add(getUserByName("ricky_"+i));
        }
        return list;
    }

    public Long insertUser(String name, Integer age) {
        User user = new User();
        user.setId(1L);
        user.setName(name);
        user.setAge(age);
        return user.getId();
    }
}
