package eu.raiffaisen.accountservicerf;


import eu.raiffaisen.accountservicerf.dto.AccountDTO;
import eu.raiffaisen.accountservicerf.entity.AccountEntity;
import eu.raiffaisen.accountservicerf.exception.AccountServiceException;
import eu.raiffaisen.accountservicerf.service.AccountService;


import eu.raiffaisen.accountservicerf.service.ObjectsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AccountServiceRfApplicationTests {

    @Autowired
    AccountService accountService;

    @Autowired
	ObjectsMapper objectsMapper;

	@Test
    public void test_account_not_found() {
        final String IBAN = "00000";
		Exception exception = assertThrows(AccountServiceException.class,()->{
			accountService.getAccount(IBAN);
		});
		assertEquals("Account " + IBAN + " not found!", exception.getMessage());
    }

    @Test
	public void test_dto_mapping(){
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setCcy("EUR");
		accountEntity.setIban("1234xxx");
		accountEntity.setBalance(555.66);
		accountEntity.setLastUpdateDate(LocalDate.now());

		AccountDTO accountDTO =objectsMapper.accountEntityToAccountDTO(accountEntity);
		assertEquals(accountDTO.getCcy(),accountEntity.getCcy());
		assertEquals(accountDTO.getIban(),accountEntity.getIban());
		assertEquals(accountDTO.getBalance(),accountEntity.getBalance());
		assertEquals(accountDTO.getLastUpdateDate(),accountEntity.getLastUpdateDate());
	}
}
