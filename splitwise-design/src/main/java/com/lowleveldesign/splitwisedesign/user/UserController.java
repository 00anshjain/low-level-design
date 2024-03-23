package com.lowleveldesign.splitwisedesign.user;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User> userList;

    public UserController() {
        userList = new ArrayList<>();
    }

    public UserController(List<User> usersList) {
        this.userList = usersList;
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUser(String userId) {
        for (User user : userList) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        throw new RuntimeException("No user found with userId = " + userId);
    }

    public void addUser(User user) {
        userList.add(user);
    }
}
