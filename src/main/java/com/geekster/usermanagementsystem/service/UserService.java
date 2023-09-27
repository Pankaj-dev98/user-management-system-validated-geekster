package com.geekster.usermanagementsystem.service;

import com.geekster.usermanagementsystem.entity.User;
import com.geekster.usermanagementsystem.repo.UserDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    private UserDataAccess userDAO;

    @Autowired
    public UserService(UserDataAccess userDAO) {
        this.userDAO = userDAO;
    }

    public String addUser(User user) {
        if(userDAO.persist(user))
            return "user with " + user.getUserId() + " was added";

        return "user with " + user.getUserId() + " already exist";
    }

    public User getUserById(@PathVariable int id) {
        User user = userDAO.find(id);

        if(user == null) {
            System.out.println("user does not exist");
        }
        return user;
    }

    public List<User> getAllUsers() {
        return userDAO.fetchAll();
    }

    public String updateUser(int userId, LocalDate dateOfBirth, String userName, String phoneNumber, String email) {
        User user = userDAO.find(userId);

        if(user == null)
            return "invalid id";

        user.setUserName(userName);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
        user.setDateOfBirth(dateOfBirth);

        return "User info updated";
    }

    public String deleteUserById(int id) {
        if(userDAO.delete(id))
            return "user was deleted";

        return "user does not exist";
    }
}
