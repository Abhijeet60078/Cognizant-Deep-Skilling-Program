public class Main {

    public static void main(String[] args) {

        Logger obj1 = Logger.getInstance();
        Logger obj2 = Logger.getInstance();

        obj1.display();

        if (obj1 == obj2) {
            System.out.println("Only one object created");
        }
    }
}