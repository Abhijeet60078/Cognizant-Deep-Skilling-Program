interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {

    public void pay(int amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card");
    }
}

class PayPalPayment implements PaymentStrategy {

    public void pay(int amount) {
        System.out.println("Paid Rs." + amount + " using PayPal");
    }
}

class PaymentContext {

    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(int amount) {
        paymentStrategy.pay(amount);
    }
}

public class StrategyPattern {

    public static void main(String[] args) {

        PaymentContext payment1 =
                new PaymentContext(new CreditCardPayment());

        payment1.executePayment(5000);

        PaymentContext payment2 =
                new PaymentContext(new PayPalPayment());

        payment2.executePayment(3000);
    }
}