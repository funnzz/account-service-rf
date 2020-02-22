package eu.raiffaisen.accountservicerf.repository;

import eu.raiffaisen.accountservicerf.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface AccountRepository extends CrudRepository<AccountEntity, String> {

    Optional<AccountEntity> findByIban(String iban);
}
