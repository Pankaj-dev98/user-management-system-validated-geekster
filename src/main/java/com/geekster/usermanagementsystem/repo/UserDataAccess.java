package com.geekster.usermanagementsystem.repo;

import com.geekster.usermanagementsystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDataAccess {
    List<User> userList;

    @Autowired
    public UserDataAccess(@Qualifier("listProvider") List<User> userList) {
        this.userList = userList;
    }


    public boolean persist(User user) {
        User searched = search(user.getUserId());

        if(searched == null) {
            userList.add(user);
            return true;
        }

        return false;
    }

    public User find(int id) {
        User searched = search(id);

        if(searched == null)
            System.out.println("user does not exist");

        return searched;
    }

    private User search(int id) {
        for(User e: userList) {
            if(e.getUserId() == id)
                return e;
        }

        return null;
    }

    public List<User> fetchAll() {
        return userList;
    }

    public boolean delete(int id) {
        User searched = search(id);

        if(searched == null)
            return false;

        userList.remove(searched);
        return true;
    }
}
