package eu.raiffaisen.accountservicerf.service;

import eu.raiffaisen.accountservicerf.dto.AccountDTO;
import eu.raiffaisen.accountservicerf.entity.AccountEntity;
import org.mapstruct.Mapper;


@Mapper
public interface ObjectsMapper {

    AccountDTO accountEntityToAccountDTO(AccountEntity accountEntity);
    AccountEntity accountDTOToAccountEntity(AccountDTO accountDTO);

}
