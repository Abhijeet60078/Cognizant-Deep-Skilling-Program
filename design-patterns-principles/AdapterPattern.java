interface PaymentProcessor {
    void processPayment(double amount);
}


class PayPalGateway {

    public void makePayment(double amount) {
        System.out.println("Payment of Rs." + amount + " processed using PayPal");
    }
}


class StripeGateway {

    public void payAmount(double amount) {
        System.out.println("Payment of Rs." + amount + " processed using Stripe");
    }
}


class PayPalAdapter implements PaymentProcessor {

    private PayPalGateway paypal;

    public PayPalAdapter(PayPalGateway paypal) {
        this.paypal = paypal;
    }

    public void processPayment(double amount) {
        paypal.makePayment(amount);
    }
}


class StripeAdapter implements PaymentProcessor {

    private StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }

    public void processPayment(double amount) {
        stripe.payAmount(amount);
    }
}

public class AdapterPattern {

    public static void main(String[] args) {

        PaymentProcessor p1 =
                new PayPalAdapter(new PayPalGateway());

        PaymentProcessor p2 =
                new StripeAdapter(new StripeGateway());

        p1.processPayment(1000);
        p2.processPayment(2000);
    }
}