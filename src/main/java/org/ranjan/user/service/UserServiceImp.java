package org.ranjan.user.service;

import org.ranjan.user.exception.ResourceNotFountException;
import org.ranjan.user.model.Rating;
import org.ranjan.user.model.User;
import org.ranjan.user.respository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepo userRepo;

    @Autowired
    RestTemplate getRestTemplate;

    public User saveUser(User u){

        return userRepo.save(u);

    }

    public User getUser(Long id)
    {
        User u=userRepo.findById(id).orElseThrow(()->new ResourceNotFountException(id));
        if(u!=null){

            //http://localhost:8083/Rating/getRatingByUserId/154

            List<Rating> ratings=getRestTemplate.getForObject("http://localhost:8083/Rating/getRatingByUserId/154", ArrayList.class);
            u.setRating(ratings);
            return u;
        }
        else{
            return null;
        }
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }

    public void deleteUser(User u)
    {
        userRepo.delete(u);
    }

    public List<User> getAllUsers(){

        return userRepo.findAll();
    }

    public List<User> getAllUsers(Integer pageNumber, Integer pageSize){

        PageRequest pq=PageRequest.of(pageNumber,pageSize);
        return userRepo.findAll(pq).getContent();

    }

    public long userCount(){
        return userRepo.count();
    }

    public List<User> getUserByName(String name){
        return  userRepo.getUserByName(name);
    }




}
