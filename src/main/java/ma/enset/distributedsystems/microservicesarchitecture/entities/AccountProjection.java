package ma.enset.distributedsystems.microservicesarchitecture.entities;

import ma.enset.distributedsystems.microservicesarchitecture.entities.Account;
import ma.enset.distributedsystems.microservicesarchitecture.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = Account.class)
public interface AccountProjection {
    public Double getId();
    public AccountType getType();
}
