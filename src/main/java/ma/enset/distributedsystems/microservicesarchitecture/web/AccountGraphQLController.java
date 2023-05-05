package ma.enset.distributedsystems.microservicesarchitecture.web;

import ma.enset.distributedsystems.microservicesarchitecture.dto.AccountRequestDTO;
import ma.enset.distributedsystems.microservicesarchitecture.dto.AccountResponseDTO;
import ma.enset.distributedsystems.microservicesarchitecture.entities.Account;
import ma.enset.distributedsystems.microservicesarchitecture.entities.Customer;
import ma.enset.distributedsystems.microservicesarchitecture.mappers.AccountMapper;
import ma.enset.distributedsystems.microservicesarchitecture.repositories.AccountRepository;
import ma.enset.distributedsystems.microservicesarchitecture.repositories.CustomerRepository;
import ma.enset.distributedsystems.microservicesarchitecture.service.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AccountGraphQLController {

    private AccountRepository accountRepository;
    private AccountService accountService;
    private CustomerRepository customerRepository;

    public AccountGraphQLController(AccountRepository accountRepository, AccountService accountService, AccountMapper accountMapper, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
        this.customerRepository = customerRepository;
    }

    @QueryMapping
    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    @QueryMapping
    public Account getAccountById(@Argument long id){
        return accountRepository.findById(id).get();
    }

    @MutationMapping
    public AccountResponseDTO addAccount(@Argument AccountRequestDTO accountRequestDTO){
        return accountService.addAccount(accountRequestDTO);
    }

    @MutationMapping
    public AccountResponseDTO updateAccount(@Argument AccountRequestDTO accountRequestDTO,@Argument int id){
        return accountService.updateAccount(accountRequestDTO, id);
    }

    @MutationMapping
    public boolean deleteAccount(@Argument long id){
        accountRepository.deleteById(id);
        return true;
    }

    @QueryMapping
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
}
