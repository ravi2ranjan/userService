package org.ranjan.user.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.ranjan.user.model.User;
import org.ranjan.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<User> getAllUser(){

        return userService.getAllUsers();
    }

    @PostMapping("/add-user")
    public ResponseEntity<User> addUSer(@RequestBody User u)
    {
        User user=userService.saveUser(u);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    @CircuitBreaker(name="ratingBreaker",fallbackMethod = "ratingFallback")
    public ResponseEntity<User>  getUserById(@PathVariable Long id)
    {
        User u=userService.getUser(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(u);
    }

    public ResponseEntity<User> ratingFallback(Long id,Exception ex){
        User user=User.builder().userID(id).about("Service is down").name("FaultTolerance").build();
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/delete-id/{id}")
    public void deleteID(@PathVariable Long id)
    {
        userService.deleteUser(id);
    }

    @DeleteMapping("/delete-id/")
    public void deleteUser(@RequestBody User u)
    {
        userService.deleteUser(u);
    }

    @GetMapping("/getUsers/")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam Integer pageNumber,@RequestParam Integer pageSize)
    {
        System.out.println("PageNumber="+pageNumber+"   "+"pageSize="+pageSize);
        List<User> users=userService.getAllUsers(pageNumber,2);
        return ResponseEntity.status(HttpStatus.FOUND).body(users);
    }

    @GetMapping("/GetUserByName/{name}")
    public List<User> getUserByName(@PathVariable String name )
    {
        return userService.getUserByName(name);
    }

    @GetMapping("/GetUserByName/test/")
    public List<User> getUserByName2(@RequestParam String name )
    {
        return userService.getUserByName(name);
    }



}
