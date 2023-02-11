package com.cardServices.cardServices.controller;

import com.cardServices.cardServices.entity.Token;
import com.cardServices.cardServices.entity.User;
import com.cardServices.cardServices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/", produces="application/json")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserRepository userRepo;
    @GetMapping("users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }
    @GetMapping("users/{Id}")
    public ResponseEntity<User> getUser(@PathVariable Long Id){
        Optional<User> user= userRepo.findById(Id);
        System.out.println("Get {{ URL }}/users/"+ Id + "");
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
    @GetMapping("users/username/{username}")
    public ResponseEntity<Integer> getUserId(@PathVariable String username){
        Optional<User> user= userRepo.findByUserName(username);
        System.out.println("Get {{ URL }}/users/username/"+ username + "");
        return user.map(value -> new ResponseEntity<>(value.getUid(), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
    @PostMapping("users/login")
    public ResponseEntity<Boolean> getUserLogin(@RequestBody String userName, @RequestBody String pass){
        Optional<User> user= userRepo.findByUserName(userName);
        System.out.println("Get {{ URL }}/users/username/"+ userName + "");
        if(user.isPresent()){
            if(user.get().getPass() == pass)
                return new ResponseEntity<>(Boolean.TRUE,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @PostMapping("users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        if(user == null)
            return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
        userRepo.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @PutMapping("users/{Id}")
    public ResponseEntity<User> updateUser(@PathVariable Long Id,@RequestBody User newUser){
        if(Id == null || newUser == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        Optional<User> user = userRepo.findById(Id);
        System.out.println("PUT {{ URL }}/users/"+ Id +" | user:"+ newUser + "");
        if (user.isPresent()){
            userRepo.updateUser(newUser.getFirstName(),newUser.getLastName(),newUser.getMiddleName(),newUser.getAge(),
                    newUser.getEmail(),newUser.getMobile(),Id);
            System.out.println("User "+Id+" Updated");
            return new ResponseEntity<>(user.get(), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("users/{Id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long Id){
        System.out.println("DELETE {{ URL }}/users/"+ Id +"");
        Optional<User> user = userRepo.findById(Id);
        if(user.isPresent()){
            userRepo.deleteById(Id);
            return new ResponseEntity<>("User "+Id+" Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/auth")
    public String getAuth(){
        Optional<User> us = userRepo.findByUserName("Bhardwajg2411");
        us.ifPresent(System.out::println);
//        String message="Issued an OTP for verification of Application";
//        String body="<h1>" + token.generateJWTToken() + "</h1>";
//        emailService.SendMail(emailId, message, body);
        return "";
    }
}
