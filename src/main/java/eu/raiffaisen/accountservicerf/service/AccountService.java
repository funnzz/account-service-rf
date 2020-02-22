package eu.raiffaisen.accountservicerf.service;


import eu.raiffaisen.accountservicerf.dto.AccountDTO;
import eu.raiffaisen.accountservicerf.entity.AccountEntity;
import eu.raiffaisen.accountservicerf.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ObjectsMapper objectsMapper;

    public AccountDTO getAccount(String iban) throws Exception {
        Optional<AccountEntity> accountEntityOptional = accountRepository.findByIban(iban);

        return accountEntityOptional.map(accountEntity->objectsMapper.mapperToAccountDTO(accountEntity)).orElseThrow(()-> new Exception("not found"));
    }

    public void saveAccount(AccountDTO accountDTO){
        accountRepository.save(objectsMapper.mapperToAccountEntity(accountDTO));
    }






}
