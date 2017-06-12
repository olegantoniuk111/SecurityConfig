package vin.gans.customExeptions;

/**
 * Created by root on 23.05.17.
 */
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
