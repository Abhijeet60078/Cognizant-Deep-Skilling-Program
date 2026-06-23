class Logger {

    private static Logger obj;

    private Logger() {
    }

    public static Logger getInstance() {

        if (obj == null) {
            obj = new Logger();
        }

        return obj;
    }

    public void display() {
        System.out.println("Logger object created");
    }
}

public class Singleton {

    public static void main(String[] args) {

        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();

        l1.display();

        if (l1 == l2) {
            System.out.println("Only one object is created");
        } else {
            System.out.println("Multiple objects created");
        }
    }
}