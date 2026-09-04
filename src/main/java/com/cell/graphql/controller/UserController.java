package com.cell.graphql.controller;

import com.cell.graphql.Service.UserService;
import com.cell.graphql.entity.User;
import com.cell.graphql.payload.UserCO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userservice;

   // @PostMapping("/create")
    @MutationMapping      //if method name not matching then @MutationMapping(name="saveUser")
                          // like this with the schema.graphqls in type mutation
    public User createUser(@Argument("user") UserCO userCO){
        System.out.println("UserCO = " + userCO);

        User user = UserCO.mapUser(userCO);

        System.out.println("Mapped User = " + user);

        return userservice.createUser(user);
    }

    @QueryMapping(name ="getAllUsers")
    public List<User> getAllUser(){
        List<User> allUser = userservice.getAllUser();
        return allUser;
    }

    @QueryMapping(name = "getUser")
    public User getUserByUserId(@Argument("userId") long  userId){
        User userByUserId = userservice.getUserByUserId(userId);
        return userByUserId;
    }
}
