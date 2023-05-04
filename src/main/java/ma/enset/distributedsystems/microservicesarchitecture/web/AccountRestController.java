package ma.enset.distributedsystems.microservicesarchitecture.web;

import ma.enset.distributedsystems.microservicesarchitecture.entities.Account;
import ma.enset.distributedsystems.microservicesarchitecture.enums.AccountType;
import ma.enset.distributedsystems.microservicesarchitecture.exceptions.AccountNotFoundException;
import ma.enset.distributedsystems.microservicesarchitecture.repositories.AccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private AccountRepository accountRepository;

    public AccountRestController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
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
    public Account save(@RequestBody Account account){
        return accountRepository.save(account);
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
}
