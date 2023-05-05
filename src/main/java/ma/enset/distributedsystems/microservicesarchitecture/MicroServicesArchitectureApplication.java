package ma.enset.distributedsystems.microservicesarchitecture;

import ma.enset.distributedsystems.microservicesarchitecture.entities.Account;
import ma.enset.distributedsystems.microservicesarchitecture.entities.Customer;
import ma.enset.distributedsystems.microservicesarchitecture.enums.AccountType;
import ma.enset.distributedsystems.microservicesarchitecture.repositories.AccountRepository;
import ma.enset.distributedsystems.microservicesarchitecture.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class MicroServicesArchitectureApplication implements CommandLineRunner{

	private final AccountRepository accountRepository;
	private final CustomerRepository customerRepository;

	// Initialize accountRepository using the application constructor
	public MicroServicesArchitectureApplication(AccountRepository accountRepository, CustomerRepository customerRepository){
		this.accountRepository = accountRepository;
		this.customerRepository = customerRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(MicroServicesArchitectureApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Create and store some customers in an H2 Database
		Stream.of("Ahmed", "Mustapha", "Imane", "Hind").forEach(name -> {
			Customer customer = Customer.builder()
					.name(name)
					.build();
			customerRepository.save(customer);
		});

		// Add some accounts to each customer
		customerRepository.findAll().forEach(customer -> {
			for(int i = 0; i < 3; i++){
				Account account = Account.builder()
						.createdAt(new Date())
						.balance(Math.random()*10000)
						.currency(Math.random() > 0.5 ? "USD" : "MAD")
						.type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVINGS_ACCOUNT)
						.customer(customer)
						.build();
				accountRepository.save(account);
			}
		});
	}
}
