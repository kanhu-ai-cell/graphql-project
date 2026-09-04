package com.cell.graphql.Service;

import com.cell.graphql.entity.User;
import com.cell.graphql.excepton.ExceptionHelper;
import com.cell.graphql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        List<User> userList = userRepository.findAll();
        return userList;
    }
    public User getUserByUserId(long userid){
        User user = userRepository.findById(userid).orElseThrow(() -> new ExceptionHelper("resource not found with id" + userid));
        return user;
    }

    public User updateUser(User user){
        User usdb = userRepository.findById(user.getId()).orElseThrow(() -> new ExceptionHelper("resource not found with id" + user.getId()));

        if(usdb !=null){
            usdb.setUsername(user.getUsername());
            usdb.setEmail(user.getEmail());
            usdb.setMobile_no(user.getMobile_no());
            usdb.setAlternate_no(user.getAlternate_no());
            usdb.setWhtsappMobNo(user.getWhtsappMobNo());
            usdb.setFirst_name(user.getFirst_name());
            usdb.setLast_name(user.getLast_name());
            usdb.setPresentAddress(user.getPresentAddress());
            usdb.setPermanentAddress(user.getPermanentAddress());
            usdb.setGender(user.getGender());
            usdb.setDateOfBirth(user.getDateOfBirth());
            usdb.setAge(user.getAge());
            usdb.setDescription(user.getDescription());
            userRepository.save(usdb);
            return usdb;
        }else{
           return null;
        }
    }
}
