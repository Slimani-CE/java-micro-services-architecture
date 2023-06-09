package ma.enset.distributedsystems.microservicesarchitecture.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import ma.enset.distributedsystems.microservicesarchitecture.dto.AccountRequestDTO;
import ma.enset.distributedsystems.microservicesarchitecture.dto.AccountResponseDTO;
import ma.enset.distributedsystems.microservicesarchitecture.entities.Account;
import ma.enset.distributedsystems.microservicesarchitecture.entities.Customer;
import ma.enset.distributedsystems.microservicesarchitecture.exceptions.AccountNotFoundException;
import ma.enset.distributedsystems.microservicesarchitecture.repositories.AccountRepository;
import ma.enset.distributedsystems.microservicesarchitecture.repositories.CustomerRepository;
import ma.enset.distributedsystems.microservicesarchitecture.service.AccountService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private AccountRepository accountRepository;
    private AccountService accountService;
    private CustomerRepository customerRepository;

    public AccountRestController(AccountRepository accountRepository, AccountService accountService, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Account getById(@PathVariable long id){
        return accountRepository.findById(id).orElseThrow(()-> new AccountNotFoundException(String.format("Account with Id %d not found !", id)));
    }

    @PostMapping("/accounts")
    public AccountResponseDTO save(@RequestBody AccountRequestDTO account){
        return accountService.addAccount(account);
    }

    @PutMapping("/accounts/{id}")
    public Account update(@RequestBody Account account, @PathVariable long id){
        Account tmpAccount = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException(String.format("Account with Id %d not found !", id)));
        if(account.getCreatedAt() != null) tmpAccount.setCreatedAt(account.getCreatedAt());
        if(account.getBalance() != null) tmpAccount.setBalance(account.getBalance());
        if(account.getCurrency() != null) tmpAccount.setCurrency(account.getCurrency());
        if(account.getType() != null) tmpAccount.setType(account.getType());
        return accountRepository.save(tmpAccount);
    }

    @DeleteMapping("/accounts/{id}")
    public void delete(@PathVariable long id){
        accountRepository.deleteById(id);
    }

    @GetMapping("/customers")
    public List<Customer> customers(){
        return customerRepository.findAll();
    }
}
