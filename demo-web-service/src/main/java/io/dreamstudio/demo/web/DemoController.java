package io.dreamstudio.demo.web;

import io.dreamstudio.demo.model.User;
import io.dreamstudio.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ricky Fung
 */
@RestController
@RequestMapping("/api/demo")
public class DemoController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "userService")
    private UserService userService;

    @GetMapping("/users/info")
    public User getUser(@RequestParam("name") String name) {
        User user = userService.getUserByName(name);
        return user;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> list = userService.getAllUsers();
        return list;
    }

    @GetMapping("/users/create")
    public Long createUser(@RequestParam("name") String name,
                           @RequestParam("age") Integer age) {
        Long id = userService.insertUser(name, age);
        return id;
    }
}
