package exceptions;

public class InvalidJSONFormatException extends CLIException {
    public InvalidJSONFormatException(String message) {
        super(message);
    }
}
