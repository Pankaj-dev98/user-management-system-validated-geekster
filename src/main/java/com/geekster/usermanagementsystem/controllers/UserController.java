package com.geekster.usermanagementsystem.controllers;

import com.geekster.usermanagementsystem.entity.User;
import com.geekster.usermanagementsystem.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // endpoint to add user (parses json)
    @PostMapping("/user/add")
    public String addUser(@RequestBody @Valid User user) {
        return userService.addUser(user);
    }

    @GetMapping("/user/get/{id}")
    public User getUserById(@NotNull Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user/get/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/user/{id}/update")
    public String updateUser(
            @PathVariable @NotNull Integer id,
            @RequestParam LocalDate dateOfBirth,
            @RequestParam @Valid String userName,
            @RequestParam @Valid String phoneNumber,
            @RequestParam @Valid String email)
    {
        return userService.updateUser(id, dateOfBirth, userName, phoneNumber, email);
    }

    @PutMapping("/user/{id}/delete")
    public String deleteUserById(@PathVariable int id) {
        return userService.deleteUserById(id);
    }
}
