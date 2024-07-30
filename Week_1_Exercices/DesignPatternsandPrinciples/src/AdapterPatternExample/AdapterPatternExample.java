package AdapterPatternExample;

interface PaymentProcessor {
    void processPayment(double amount);
}

class PaypalService {
    public void makePayment(double amount) {
        System.out.println("Payment of $" + amount + " made through PayPal.");
    }
}

class CreditCardService {
    public void charge(double amount) {
        System.out.println("Charged $" + amount + " to credit card.");
    }
}

class PaypalAdapter implements PaymentProcessor {
    private PaypalService paypalService;

    public PaypalAdapter(PaypalService paypalService) {
        this.paypalService = paypalService;
    }

    @Override
    public void processPayment(double amount) {
        paypalService.makePayment(amount);
    }
}

class CreditCardAdapter implements PaymentProcessor {
    private CreditCardService creditCardService;

    public CreditCardAdapter(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @Override
    public void processPayment(double amount) {
        creditCardService.charge(amount);
    }
}

// Test the Adapter Pattern
public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PaypalAdapter(new PaypalService());
        paypalProcessor.processPayment(100.0);

        PaymentProcessor creditCardProcessor = new CreditCardAdapter(new CreditCardService());
        creditCardProcessor.processPayment(200.0);
    }
}
