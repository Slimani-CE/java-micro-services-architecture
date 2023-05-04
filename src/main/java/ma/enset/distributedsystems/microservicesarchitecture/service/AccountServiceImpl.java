package ma.enset.distributedsystems.microservicesarchitecture.service;

import ma.enset.distributedsystems.microservicesarchitecture.dto.AccountRequestDTO;
import ma.enset.distributedsystems.microservicesarchitecture.dto.AccountResponseDTO;
import ma.enset.distributedsystems.microservicesarchitecture.entities.Account;
import ma.enset.distributedsystems.microservicesarchitecture.mappers.AccountMapper;
import ma.enset.distributedsystems.microservicesarchitecture.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountResponseDTO addAccount(AccountRequestDTO accountRequestDTO) {
        // Mapping accountRequestDTO entity => Account entity
        Account account = accountMapper.accountFromRequest(accountRequestDTO);

        // Save Account entity and retrieve new Account entity with id
        Account savedAccount = accountRepository.save(account);

        // Mapping Account entity => AccountResponseDTO
        AccountResponseDTO responseDTO = accountMapper.responseFromAccount(savedAccount);
        return responseDTO;
    }
}
