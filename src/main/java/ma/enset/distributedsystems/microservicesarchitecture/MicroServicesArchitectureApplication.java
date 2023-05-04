package ma.enset.distributedsystems.microservicesarchitecture;

import ma.enset.distributedsystems.microservicesarchitecture.entities.Account;
import ma.enset.distributedsystems.microservicesarchitecture.enums.AccountType;
import ma.enset.distributedsystems.microservicesarchitecture.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class MicroServicesArchitectureApplication implements CommandLineRunner{

	private final AccountRepository accountRepository;

	// Initialize accountRepository using the application constructor
	public MicroServicesArchitectureApplication(AccountRepository accountRepository){
		this.accountRepository = accountRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(MicroServicesArchitectureApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Create and store entities in an H2 Database
		for(int i = 0; i < 10; i++){
			Account account = Account.builder()
					.createdAt(new Date())
					.balance(Math.random()*10000)
					.currency(Math.random() > 0.5 ? "USD" : "MAD")
					.type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVINGS_ACCOUNT)
					.build();
			accountRepository.save(account);
		}
	}
}
