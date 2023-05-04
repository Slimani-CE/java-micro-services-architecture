package ma.enset.distributedsystems.microservicesarchitecture.exceptions;

public class AccountNotFoundException extends RuntimeException{
    private String message;

    public AccountNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AccountNotFoundException{" +
                "message='" + message + '\'' +
                '}';
    }
}
