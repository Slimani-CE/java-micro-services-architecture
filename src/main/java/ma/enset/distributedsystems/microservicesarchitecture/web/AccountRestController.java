package ma.enset.distributedsystems.microservicesarchitecture.web;

import ma.enset.distributedsystems.microservicesarchitecture.entities.Account;
import ma.enset.distributedsystems.microservicesarchitecture.exceptions.AccountNotFoundException;
import ma.enset.distributedsystems.microservicesarchitecture.repositories.AccountRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @PutMapping("/accounts")
    public Account update(@RequestBody Account account, @PathVariable long id){
        account.setId(id);
        return accountRepository.save(account);
    }

    @DeleteMapping("/accounts")
    public void delete(@PathVariable long id){
        accountRepository.deleteById(id);
    }
}
