package singletonpackage;

public class Logger {
    // Step 2: Define a private static instance of Logger
    private static Logger instance;

    // Step 2: Ensure the constructor is private
    private Logger() {
        // private constructor to prevent instantiation
    }

    // Step 2: Provide a public static method to get the instance of Logger
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Example method to demonstrate logging functionality
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}
