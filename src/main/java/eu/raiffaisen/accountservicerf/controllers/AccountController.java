package eu.raiffaisen.accountservicerf.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu.raiffaisen.accountservicerf.dto.AccountDTO;
import eu.raiffaisen.accountservicerf.dto.ExchangeRatesDTO;
import eu.raiffaisen.accountservicerf.exception.AccountServiceException;
import eu.raiffaisen.accountservicerf.service.AccountService;
import eu.raiffaisen.accountservicerf.service.ExchangeRateProvider;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account-api/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;


    @GetMapping("/{iban}")
    public ResponseEntity<AccountDTO> findByIban(@PathVariable String iban) throws ParseException, JsonProcessingException, AccountServiceException {

        return new ResponseEntity<>(accountService.getAccount(iban), HttpStatus.OK);
    }



}
