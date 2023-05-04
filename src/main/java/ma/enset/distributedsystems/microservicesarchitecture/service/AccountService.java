package ma.enset.distributedsystems.microservicesarchitecture.service;

import ma.enset.distributedsystems.microservicesarchitecture.dto.AccountRequestDTO;
import ma.enset.distributedsystems.microservicesarchitecture.dto.AccountResponseDTO;
import ma.enset.distributedsystems.microservicesarchitecture.entities.Account;

public interface AccountService {
    public AccountResponseDTO addAccount(AccountRequestDTO accountRequestDTO);
    public AccountResponseDTO updateAccount(AccountRequestDTO accountRequestDTO, long id);
}
