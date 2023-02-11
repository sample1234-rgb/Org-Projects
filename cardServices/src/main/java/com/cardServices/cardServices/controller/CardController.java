package com.cardServices.cardServices.controller;

import com.cardServices.cardServices.entity.Card;
import com.cardServices.cardServices.entity.User;
import com.cardServices.cardServices.repository.CardRepository;
import com.cardServices.cardServices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/", produces="application/json")
@CrossOrigin(origins = "*")
public class CardController {
    @Autowired
    private CardRepository cardRepo;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("cards")
    public List<Card> getCards(){
        return cardRepo.findAll();
    }
    @GetMapping("cards/{Id}")
    public ResponseEntity<Card> getCard(@PathVariable Long Id){
        Optional<Card> card= cardRepo.findById(Id);
        return card.map(value -> new ResponseEntity<>(value, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
    @PostMapping("cards")
    public ResponseEntity<Card> createCard(@RequestBody Card card){
        if(card == null)
            return new ResponseEntity<>(card, HttpStatus.BAD_REQUEST);
        Optional<User> u = userRepository.findById((long) card.getOwner());
        if(u == null)
            return new ResponseEntity<>(card, HttpStatus.INTERNAL_SERVER_ERROR);
        cardRepo.save(card);
        return new ResponseEntity<>(card, HttpStatus.CREATED);
    }
    @PutMapping("cards/{Id}")
    public ResponseEntity<Card> updateCard(@PathVariable Integer Id,@RequestBody Card newCard){
        if(Id == null || newCard == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        Optional<Card> card = cardRepo.findById((long) Id);
        if (card.isPresent()){
            cardRepo.updateCard(newCard.getCardNumber(),newCard.getOwner(),newCard.getIssuer(),newCard.getCvv(),
                    newCard.getNFC(),newCard.getCardType(),newCard.getExpiration(),newCard.getIssueDate(),
                    newCard.getVerifyCodes(),Id);
            System.out.println("Card "+Id+" Updated");
            return new ResponseEntity<>(card.get(), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("cards/{Id}")
    public ResponseEntity<String> deleteCard(@PathVariable Long Id){
        Optional<Card> card = cardRepo.findById(Id);
        if(card.isPresent()){
            cardRepo.deleteById(Id);
            return new ResponseEntity<>("card "+Id+" Deteted", HttpStatus.OK);
        }
        return new ResponseEntity<>("card not found",HttpStatus.NOT_FOUND);

    }
}
