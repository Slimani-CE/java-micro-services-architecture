package ma.enset.distributedsystems.microservicesarchitecture.repositories;

import ma.enset.distributedsystems.microservicesarchitecture.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

}
