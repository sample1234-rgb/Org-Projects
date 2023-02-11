package com.cardServices.cardServices.services;

import com.cardServices.cardServices.entity.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.InputStream;

@Service
@ConfigurationProperties("spring.mail")
public class EmailService {
    @Autowired
    private Token token;
    private JavaMailSender mailSender;
    private String username;
    private String subject;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getToken(){
        return token.generate();
    }
    public Boolean SendMail(String subject, String message,String body){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("bhardwajg2411@gmail.com");
        mailMessage.setTo(subject);
        mailMessage.setSubject(message);
        mailMessage.setText(body);
        System.out.println("Mail Ready to send");
//        mailSender = new JavaMailSenderImpl();
        try {
            mailSender.send(mailMessage);
            System.out.println("Mail sent");
            return true;
        }catch (Exception e){
            System.out.println("error: "+ e.getMessage());
            return false;
        }
    }
}
