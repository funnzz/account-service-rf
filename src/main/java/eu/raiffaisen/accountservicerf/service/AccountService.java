package eu.raiffaisen.accountservicerf.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import eu.raiffaisen.accountservicerf.dto.AccountDTO;
import eu.raiffaisen.accountservicerf.dto.ExchangeRatesDTO;
import eu.raiffaisen.accountservicerf.entity.AccountEntity;
import eu.raiffaisen.accountservicerf.exception.AccountServiceException;
import eu.raiffaisen.accountservicerf.repository.AccountRepository;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ExchangeRateProvider exchangeRateProvider;

    @Autowired
    ObjectsMapper objectsMapper;


    //@HystrixCommand(fallbackMethod = "cachedData")
    public AccountDTO getAccount(String iban) throws AccountServiceException, ParseException {
        Optional<AccountEntity> accountEntityOptional = accountRepository.findByIban(iban);
        AccountDTO accountDTO = accountEntityOptional
                .map(p -> objectsMapper.accountEntityToAccountDTO(p))
                .orElseThrow(() -> new AccountServiceException("Account " + iban + " not found!"));
        ExchangeRatesDTO exchangeRatesDTO = exchangeRateProvider.getExchangerates();

        return accountDTO;
    }

//    private ExchangeRatesDTO cachedData() throws ParseException {
//        System.out.println("Test DATA");
//        return exchangeRateProvider.getExchangerates();
//    }

}
