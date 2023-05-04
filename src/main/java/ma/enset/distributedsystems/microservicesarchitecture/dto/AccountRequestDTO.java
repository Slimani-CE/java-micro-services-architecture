package ma.enset.distributedsystems.microservicesarchitecture.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.distributedsystems.microservicesarchitecture.enums.AccountType;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class AccountRequestDTO {
    private Double balance;
    private String currency;
    private AccountType type;
}
