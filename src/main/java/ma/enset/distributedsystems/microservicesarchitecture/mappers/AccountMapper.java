package ma.enset.distributedsystems.microservicesarchitecture.mappers;

import ma.enset.distributedsystems.microservicesarchitecture.dto.AccountRequestDTO;
import ma.enset.distributedsystems.microservicesarchitecture.dto.AccountResponseDTO;
import ma.enset.distributedsystems.microservicesarchitecture.entities.Account;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    // Mapping Account entity => AccountResponseDTO entity
    public AccountResponseDTO responseFromAccount(Account account){
        AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
        BeanUtils.copyProperties(account, accountResponseDTO);
        return accountResponseDTO;
    }

    // Mapping AccountRequestDTO entity => Account entity
    public Account accountFromRequest(AccountRequestDTO accountRequestDTO){
        Account account = new Account();
        BeanUtils.copyProperties(accountRequestDTO, account);
        return account;
    }
}
