package com.cardServices.cardServices.repository;

import com.cardServices.cardServices.entity.Card;
import com.cardServices.cardServices.entity.CardIssuer;
import com.cardServices.cardServices.entity.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
    @Transactional
    @Modifying
    @Query("""
            update Card c set c.cardNumber = :cardNumber, c.Owner = :Owner, c.issuer = :issuer, c.cvv = :cvv, c.isNFC = :isNFC, c.cardType = :cardType, c.Expiration = :Expiration,c.IssueDate = :IssueDate, c.verifyCodes = :verifyCodes
            where c.cardId = :cardId""")
    int updateCard(@Param("cardNumber") String cardNumber, @Param("Owner") Integer Owner, @Param("issuer") CardIssuer issuer, @Param("cvv") String cvv, @Param("isNFC") Boolean isNFC, @Param("cardType") CardType cardType, @Param("Expiration") Date Expiration, @Param("IssueDate") Date IssueDate,@Param("verifyCodes") String verifyCodes, @Param("cardId") int cardId);

}
