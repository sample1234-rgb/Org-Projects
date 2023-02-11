package com.cardServices.cardServices.controller;

import com.cardServices.cardServices.entity.User;
import com.cardServices.cardServices.repository.UserRepository;
import com.cardServices.cardServices.services.EmailService;
import com.cardServices.cardServices.services.SMSService;
import com.cardServices.cardServices.entity.Token;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import javax.swing.text.html.parser.Entity;
import java.util.Optional;

@RestController
@RequestMapping(path="/token", produces="application/json")
@CrossOrigin(origins = "*")
public class TokenController {
    @Autowired
    private Token token;
    @Autowired
    private SMSService smsService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/email/{emailId}")
//    @EventListener(ApplicationReadyEvent.class)
    public ResponseEntity<String> EmailAuthentication(@PathVariable String emailId){
        String message="Issued an OTP for verification of Application";
        String code = token.generate();
        String body="<h1>" + code + "</h1>";
        if(emailService.SendMail(emailId, message, body))
            return new ResponseEntity<>("Sent",HttpStatus.CREATED);
        return new ResponseEntity<>("Error Occured",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PostMapping("/SMS")
    public ResponseEntity<String> MobileAuthentication(){
        String code = token.generate();
        Message message = Message.creator(
                        new PhoneNumber("+918427932049"),
                        new PhoneNumber(smsService.getTrialNumber()),
                        "Hi there, Your OTP: "+ code).create();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/JWT/{username}")
    public ResponseEntity<String> JwtGen(@PathVariable String username){
        token.setExpirationInMs(1000*60*5);
        token.setSecret("413F4428472B4B6250655368566D5971337436773979244226452948404D6351");
        Optional<User> u = userRepository.findByUserName(username);
        if(u.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        String Code = token.getJWTToken(username);
        String respBody = "{\"code\": \""+ Code +"\", \"user\":"+ u.get() +"}";
        return new ResponseEntity<>(respBody,HttpStatus.CREATED);
    }
}
