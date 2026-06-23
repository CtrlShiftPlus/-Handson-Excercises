public class App {

    interface Notifier {
        void send(String message);
    }

    static class EmailNotifier implements Notifier {
        public void send(String message) {
            System.out.println("Email sent: " + message);
        }
    }

    static abstract class NotifierDecorator implements Notifier {
        protected Notifier wrappee;

        public NotifierDecorator(Notifier wrappee) {
            this.wrappee = wrappee;
        }

        public void send(String message) {
            wrappee.send(message);
        }
    }

    static class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier wrappee) {
            super(wrappee);
        }

        public void send(String message) {
            super.send(message);
            System.out.println("SMS sent: " + message);
        }
    }

    static class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier wrappee) {
            super(wrappee);
        }

        public void send(String message) {
            super.send(message);
            System.out.println("Slack message sent: " + message);
        }
    }

    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();

        Notifier smsNotifier = new SMSNotifierDecorator(notifier);
        Notifier slackAndSms = new SlackNotifierDecorator(smsNotifier);

        slackAndSms.send("System Alert!");
    }
}