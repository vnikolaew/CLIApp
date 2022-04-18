package abstractions;

public interface CLIRequestFactory {
    CLIRequest createRequest(String requestString);
}
