package com.springrest.Forth.controller;

import com.springrest.Forth.VO.ResponseTemplateVO;
import com.springrest.Forth.entity.User;
import com.springrest.Forth.services.userServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;

@RestController
@RequestMapping("/users")
public class userController {
    @Autowired
    public userServices userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User u){
        return userService.saveUser(u);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUser(@PathVariable("id") int uid){
        return userService.getById(uid);
    }
}
