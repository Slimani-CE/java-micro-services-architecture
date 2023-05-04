package ma.enset.distributedsystems.microservicesarchitecture.repositories;

import ma.enset.distributedsystems.microservicesarchitecture.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface AccountRepository extends JpaRepository<Account, Long> {

}
