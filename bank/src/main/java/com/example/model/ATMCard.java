package com.example.model;

import com.example.model.account.Account;
import jakarta.persistence.*;

@Entity
public class ATMCard {

    @Id
    private Long cardNumber;

    private String cardType;
    private String expiryDate;
    private int cvv;

    @OneToOne
    @JoinColumn(name = "account_number")
    private Account account;

    public ATMCard() {
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}