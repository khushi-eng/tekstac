package com.example.service;

import com.example.exception.DuplicateCardException;
import com.example.exception.ResourceNotFoundException;
import com.example.model.ATMCard;
import com.example.model.account.Account;
import com.example.repository.ATMCardRepository;
import com.example.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {

    private final AccountRepository accountRepository;
    private final ATMCardRepository atmCardRepository;

    Logger logger = LoggerFactory.getLogger(BankService.class);

    public BankService(AccountRepository accountRepository,
                       ATMCardRepository atmCardRepository) {
        this.accountRepository = accountRepository;
        this.atmCardRepository = atmCardRepository;
    }

    public Account createAccount(Account account) {

        logger.info("Creating account {}", account.getAccountNumber());

        return accountRepository.save(account);
    }

    public ATMCard issueATMCard(Long accountNumber, ATMCard card) {

        Account account = accountRepository.findById(accountNumber)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Account not found"));

        if (account.getAtmCard() != null) {

            logger.error("ATM Card already exists for account {}",
                    accountNumber);

            throw new DuplicateCardException(
                    "ATM Card already issued for this account");
        }

        card.setAccount(account);
        account.setAtmCard(card);

        logger.info("ATM Card issued successfully");

        return atmCardRepository.save(card);
    }

    public List<Account> getAccountsByCardType(String cardType) {

        logger.info("Fetching accounts by card type {}", cardType);

        return accountRepository.findByAtmCardCardType(cardType);
    }
}