package com.example.controller;

import com.example.model.ATMCard;
import com.example.model.account.Account;
import com.example.service.BankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account) {

        return bankService.createAccount(account);
    }

    @PostMapping("/atm/{accountNumber}")
    public ATMCard issueATMCard(@PathVariable Long accountNumber,
                                @RequestBody ATMCard card) {

        return bankService.issueATMCard(accountNumber, card);
    }

    @GetMapping("/accounts/{cardType}")
    public List<Account> getAccountsByCardType(
            @PathVariable String cardType) {

        return bankService.getAccountsByCardType(cardType);
    }
}