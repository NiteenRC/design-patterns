package com.nc.behavioral.chain;

// Handler interface
interface HttpRequestHandler {
    void handle(HttpRequest request);

    void setNextHandler(HttpRequestHandler nextHandler);
}

class HttpRequest {
    private final String path;
    private final String method;
    private final String body;

    HttpRequest(String path, String method, String body) {
        this.path = path;
        this.method = method;
        this.body = body;
    }

    public String getPath() {
        return path;
    }

    public String getMethod() {
        return method;
    }

    public String getBody() {
        return body;
    }
}

// Concrete Handler for authentication
class AuthenticationHandler implements HttpRequestHandler {
    private HttpRequestHandler nextHandler;

    @Override
    public void handle(HttpRequest request) {
        // Simulate authentication logic
        if (request.getPath().equals("/admin") && !isLoggedIn(request)) {
            System.out.println("User is not logged in.");
            return;
        }

        if (nextHandler != null) {
            nextHandler.handle(request);
        }
    }

    private boolean isLoggedIn(HttpRequest request) {
        // Simulate authentication check
        // In a real application, this would involve checking session, cookies, or tokens
        return true;
    }

    public void setNextHandler(HttpRequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

// Concrete Handler for logging
class LoggingHandler implements HttpRequestHandler {
    private HttpRequestHandler nextHandler;

    @Override
    public void handle(HttpRequest request) {
        // Simulate logging
        System.out.println("Logging request: " + request.getMethod() + " " + request.getPath());

        if (nextHandler != null) {
            nextHandler.handle(request);
        }
    }

    public void setNextHandler(HttpRequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

// Concrete Handler for validation
class ValidationHandler implements HttpRequestHandler {
    private HttpRequestHandler nextHandler;

    @Override
    public void handle(HttpRequest request) {
        // Simulate validation
        if (request.getPath().equals("/create") && !isValid(request.getBody())) {
            System.out.println("Request body is not valid.");
            return;
        }

        if (nextHandler != null) {
            nextHandler.handle(request);
        }
    }

    private boolean isValid(String body) {
        // Simulate validation logic
        return body != null && !body.isEmpty();
    }

    public void setNextHandler(HttpRequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

// Client code
public class RequestInterceptor {
    public static void main(String[] args) {
        HttpRequestHandler authenticationHandler = new AuthenticationHandler();
        HttpRequestHandler loggingHandler = new LoggingHandler();
        HttpRequestHandler validationHandler = new ValidationHandler();

        // Construct the chain of responsibility
        authenticationHandler.setNextHandler(loggingHandler);
        loggingHandler.setNextHandler(validationHandler);

        // Simulate incoming HTTP request
        HttpRequest request1 = new HttpRequest("/admin", "GET", "");
        HttpRequest request2 = new HttpRequest("/create", "POST", "Some data");

        // Handle requests
        authenticationHandler.handle(request1); // Output: Logging request: GET /admin
        authenticationHandler.handle(request2); // Output: Logging request: POST /create
        // Output: Request body is not valid.
    }
}
