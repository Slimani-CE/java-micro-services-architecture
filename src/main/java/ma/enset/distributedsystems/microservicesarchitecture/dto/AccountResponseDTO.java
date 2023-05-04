package ma.enset.distributedsystems.microservicesarchitecture.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.distributedsystems.microservicesarchitecture.enums.AccountType;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountResponseDTO {
    private Long id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
