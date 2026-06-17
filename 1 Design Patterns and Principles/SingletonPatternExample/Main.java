public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Singleton Logger Pattern");

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application started");
        logger2.log("Processing data");

        if (logger1 == logger2) {
            System.out.println("\nSUCCESS: Both logger1 and logger2 refer to the exact same instance.");
        } else {
            System.out.println("\nFAILURE: Different instances were created.");
        }
        
        System.out.println("Logger 1 HashCode: " + logger1.hashCode());
        System.out.println("Logger 2 HashCode: " + logger2.hashCode());
    }
}