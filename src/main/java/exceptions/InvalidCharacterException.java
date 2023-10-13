package exceptions;

public class InvalidCharacterException extends RuntimeException {
    public InvalidCharacterException() {
        super("Carattere non consentito.");
    }
}
