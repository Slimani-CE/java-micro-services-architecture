package ma.enset.distributedsystems.microservicesarchitecture.repositories;

import ma.enset.distributedsystems.microservicesarchitecture.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
