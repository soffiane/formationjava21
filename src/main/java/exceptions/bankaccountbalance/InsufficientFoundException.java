package exceptions.bankaccountbalance;

public class InsufficientFoundException extends Exception{
    private String message;

    public InsufficientFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
