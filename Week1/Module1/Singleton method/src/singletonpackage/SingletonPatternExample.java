package singletonpackage;

public class SingletonPatternExample {
    public static void main(String[] args) {
        // Get the single instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Test if both logger1 and logger2 are the same instance
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }

        // Use the logger to log messages
        logger1.log("This is a log message from logger1.");
        logger2.log("This is a log message from logger2.");
    }
}
