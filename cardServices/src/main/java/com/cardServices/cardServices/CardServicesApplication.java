package com.cardServices.cardServices;

import com.cardServices.cardServices.entity.Card;
import com.cardServices.cardServices.entity.CardIssuer;
import com.cardServices.cardServices.entity.CardType;
import com.cardServices.cardServices.repository.CardRepository;
import com.cardServices.cardServices.services.SMSService;
import com.cardServices.cardServices.entity.User;
import com.cardServices.cardServices.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;

import java.util.Date;

@SpringBootApplication
public class CardServicesApplication implements CommandLineRunner {
	@Autowired
	private SMSService smsService;
	public static void main(String[] args) {
		SpringApplication.run(CardServicesApplication.class, args);
	}
	@PostConstruct
	public void initTwilio(){
		Twilio.init(smsService.getAccountSid(),smsService.getAuthToken());
	}
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CardRepository cardRepo;

	@Override
	public void run(String... args) throws Exception {
		initUsers();
		initCards();
	}
	public void initUsers(){
		User u1 = new User();
		u1.setFirstName("Gaurav");
		u1.setLastName("Bhardwaj");
		u1.setUserName("Bhardwajg2411");
		u1.setAge(22);
		u1.setEmail("bhardwajg2411@gmail.com");
		u1.setPass("GauravX2411");
		u1.setMobile("6283913449");

		User u2 = new User();
		u2.setFirstName("Tamanna");
		u2.setLastName("Bhardwaj");
		u2.setUserName("tamannab99");
		u2.setAge(19);
		u2.setEmail("tamanna99@gmail.com");
		u2.setPass("GauravX2411");
		u2.setMobile("6283913449");

		User u3 = new User();
		u3.setFirstName("Selena");
		u3.setLastName("Gomez");
		u3.setUserName("its_your_sel");
		u3.setAge(30);
		u3.setEmail("itsyoursel2207@gmail.com");
		u3.setPass("GauravX2411");
		u3.setMobile("6283913449");

		userRepo.save(u1);
		userRepo.save(u2);
		userRepo.save(u3);
	}
	public void initCards(){
		Card c1 = new Card();
		c1.setCardNumber("1230456278901234");
		c1.setCvv("123");
		c1.setCardType(CardType.DEBIT);
		c1.setIssuer(CardIssuer.VISA);
		c1.setOwner(0);
		c1.setIssueDate(new Date(System.currentTimeMillis()));
		c1.setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*24*50));
		c1.setNFC(true);
		c1.setVerifyCodes("01 10 20 10 20 30 03");

		Card c2 = new Card();
		c2.setCardNumber("1230456278901234");
		c2.setCvv("123");
		c2.setCardType(CardType.DEBIT);
		c2.setIssuer(CardIssuer.VISA);
		c2.setOwner(0);
		c2.setIssueDate(new Date(System.currentTimeMillis()));
		c2.setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*24*50));
		c2.setNFC(true);
		c2.setVerifyCodes("01 10 20 10 20 30 03");

		Card c3 = new Card();
		c3.setCardNumber("1230456278901234");
		c3.setCvv("123");
		c3.setCardType(CardType.DEBIT);
		c3.setIssuer(CardIssuer.VISA);
		c3.setOwner(0);
		c3.setIssueDate(new Date(System.currentTimeMillis()));
		c3.setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*24*50));
		c3.setNFC(true);
		c3.setVerifyCodes("01 10 20 10 20 30 03");

		cardRepo.save(c1);
		cardRepo.save(c2);
		cardRepo.save(c3);
	}
}
