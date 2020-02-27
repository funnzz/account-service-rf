package eu.raiffaisen.accountservicerf.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import eu.raiffaisen.accountservicerf.dto.AccountDTO;
import eu.raiffaisen.accountservicerf.dto.ExchangeRatesDTO;
import eu.raiffaisen.accountservicerf.entity.AccountEntity;
import eu.raiffaisen.accountservicerf.exception.AccountServiceException;
import eu.raiffaisen.accountservicerf.repository.AccountRepository;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ExchangeRateProvider exchangeRateProvider;

    @Autowired
    ObjectsMapper objectsMapper;


    @HystrixCommand(fallbackMethod = "cachedData")
    public AccountDTO getAccount(String iban) throws ParseException, AccountServiceException {
        Optional<AccountEntity> accountEntityOptional = accountRepository.findByIban(iban);
        AccountDTO accountDTO = accountEntityOptional
                .map(p -> objectsMapper.accountEntityToAccountDTO(p))
                .orElseThrow(() -> new AccountServiceException("Account " + iban + " not found!"));
        ExchangeRatesDTO exchangeRatesDTO = exchangeRateProvider.getExchangerates();

        if (!accountDTO.getCcy().equalsIgnoreCase("EUR")) {
            accountDTO.setBalance(accountDTO.getBalance() * exchangeRatesDTO.getRates().get(accountDTO.getCcy()));
            accountDTO.setCcy("EUR");
        }
        return accountDTO;
    }

    private ExchangeRatesDTO cachedData() throws ParseException {
        LOGGER.info("FallbackMethod initiated!!");
        return exchangeRateProvider.getExchangerates();
    }
}


