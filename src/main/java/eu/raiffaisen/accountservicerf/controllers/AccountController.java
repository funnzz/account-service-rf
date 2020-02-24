package eu.raiffaisen.accountservicerf.controllers;

import eu.raiffaisen.accountservicerf.dto.AccountDTO;
import eu.raiffaisen.accountservicerf.dto.ExchangeRatesDTO;
import eu.raiffaisen.accountservicerf.service.AccountService;
import eu.raiffaisen.accountservicerf.service.ExchangeRateProvider;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account-api/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

//    @Autowired
//    ExchangeRateProvider exchangeRateProvider;


    @GetMapping("/{iban}")
    public ResponseEntity<AccountDTO> findByIban(@PathVariable String iban) throws ParseException {

        return ResponseEntity.ok(accountService.getAccount(iban));
    }

//    @GetMapping("/rates")
//    public ResponseEntity<ExchangeRatesDTO> getRates() throws ParseException {
//
//        return ResponseEntity.ok(exchangeRateProvider.getExchangerates());
//    }

}
