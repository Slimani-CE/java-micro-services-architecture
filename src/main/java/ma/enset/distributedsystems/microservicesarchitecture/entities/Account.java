package ma.enset.distributedsystems.microservicesarchitecture.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.distributedsystems.microservicesarchitecture.enums.AccountType;

import java.util.Date;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Date createdAt;
    private double balance;
    private String currency;
    private AccountType type;
}
