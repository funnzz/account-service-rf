package eu.raiffaisen.accountservicerf.controllers;

import eu.raiffaisen.accountservicerf.dto.AccountDTO;
import eu.raiffaisen.accountservicerf.service.AccountService;
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

    @PostMapping("/create")
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
        AccountDTO accountDTO1 = accountDTO;
        accountService.saveAccount(accountDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(accountDTO);
    }


    @GetMapping("/{iban}")
    public ResponseEntity<AccountDTO> findByIban(@PathVariable String iban) throws Exception {


        return ResponseEntity.ok(accountService.getAccount(iban));
    }

}
