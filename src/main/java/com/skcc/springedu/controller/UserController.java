package com.skcc.springedu.controller;

import com.skcc.springedu.domain.User;
import com.skcc.springedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author HyunSub Shim
 * @since 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    List<User> getAll() {
        return userService.selectAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User get(@PathVariable("id") int id) {
        return userService.selectUser(id);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    int add(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    int remove(@PathVariable("id") int id) {
        return userService.deleteUser(id);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.PUT)
    int update(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
