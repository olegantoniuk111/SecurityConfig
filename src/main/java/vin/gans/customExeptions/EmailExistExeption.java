package vin.gans.customExeptions;

public class EmailExistExeption extends RuntimeException {

    public EmailExistExeption() {
    }

    public EmailExistExeption(String message) {
        super(message);
    }

    public EmailExistExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
