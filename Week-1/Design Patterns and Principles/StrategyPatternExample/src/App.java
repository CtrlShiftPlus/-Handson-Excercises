public class App {

    interface PaymentStrategy {
        void pay(int amount);
    }

    static class CreditCardPayment implements PaymentStrategy {
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using Credit Card");
        }
    }

    static class PayPalPayment implements PaymentStrategy {
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using PayPal");
        }
    }

    static class PaymentContext {
        private PaymentStrategy strategy;

        public void setStrategy(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        public void executePayment(int amount) {
            strategy.pay(amount);
        }
    }

    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setStrategy(new CreditCardPayment());
        context.executePayment(500);

        context.setStrategy(new PayPalPayment());
        context.executePayment(1200);
    }
}