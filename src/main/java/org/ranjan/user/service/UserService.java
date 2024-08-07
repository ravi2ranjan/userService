package org.ranjan.user.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.ranjan.user.model.User;

import java.util.List;

public interface UserService {

    //insert the user
    User saveUser(User user);

    // get the user with the help of id
    User getUser(Long id);

    //update the particular User
   // User updateUser(User user);

    void deleteUser(User user);

    void deleteUser(Long id);

    List<User> getAllUsers(Integer pageNumber, Integer pageSize);

    List<User> getAllUsers();

    long userCount();

    List<User> getUserByName(String name);

}
