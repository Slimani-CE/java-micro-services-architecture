package ma.enset.distributedsystems.microservicesarchitecture.repositories;

import ma.enset.distributedsystems.microservicesarchitecture.entities.Account;
import ma.enset.distributedsystems.microservicesarchitecture.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Long> {
    @RestResource(path = "/bytype")
    List<Account> findAccountByType(@Param("type") AccountType type);
}
