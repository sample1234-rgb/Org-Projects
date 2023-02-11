package com.cardServices.cardServices.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "card")
public class Card{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;
    @Column(name="cardNumber", nullable = false)
    private String cardNumber;

    @Column(name="owner_uid", nullable = false)
    private Integer Owner;
    @Column(name="cardType", nullable = false)
    private CardType cardType;
    @Column(name="cardIssuer", nullable = false)
    private CardIssuer issuer;
    @Column(name="IssueDate", nullable = false)
    private Date IssueDate;
    @Column(name="Expiration", nullable = false)
    private Date Expiration;
    @Column(name="NFC")
    private Boolean isNFC;
    @Column(name="cvv", nullable = false)
    private String cvv;
    @Column(name="VerifyCodes")
    private String verifyCodes;

    public Card() {}
    public Card(int cardId, String cardNumber,Integer owner, CardType cardType, CardIssuer issuer, Date issueDate,
                Date expiration, Boolean isNFC, String cvv, String verifyCodes) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        Owner = owner;
        this.cardType = cardType;
        this.issuer = issuer;
        IssueDate = issueDate;
        Expiration = expiration;
        this.isNFC = isNFC;
        this.cvv = cvv;
        this.verifyCodes = verifyCodes;
    }

    public int getCardId() { return cardId; }
    public void setCardId(int cardId) { this.cardId = cardId; }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public CardType getCardType() {
        return cardType;
    }
    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
    public CardIssuer getIssuer() {
        return issuer;
    }
    public void setIssuer(CardIssuer issuer) {
        this.issuer = issuer;
    }
    public Date getIssueDate() {
        return IssueDate;
    }
    public void setIssueDate(Date issueDate) {
        IssueDate = issueDate;
    }
    public Date getExpiration() {
        return Expiration;
    }
    public void setExpiration(Date expiration) {
        Expiration = expiration;
    }
    public Boolean getNFC() {
        return isNFC;
    }
    public void setNFC(Boolean NFC) {
        isNFC = NFC;
    }
    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    public String getVerifyCodes() {
        return verifyCodes;
    }
    public void setVerifyCodes(String verifyCodes) {
        this.verifyCodes = verifyCodes;
    }
    public Integer getOwner() {
        return Owner;
    }
    public void setOwner(Integer Owner) {
        this.Owner = Owner;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", cardNumber='" + cardNumber + '\'' +
                ", Owner=" + Owner +
                ", cardType=" + cardType +
                ", issuer=" + issuer +
                ", IssueDate=" + IssueDate +
                ", Expiration=" + Expiration +
                ", isNFC=" + isNFC +
                ", cvv='" + cvv + '\'' +
                ", verifyCodes='" + verifyCodes + '\'' +
                '}';
    }
}
