package org.vikram.facadepattern;

/*
Processing credit card payemnt:

1. Check cc details
2. Encrypt sensitive data
3. Check for fraud
4. Process Payment
5. Send confirmation
 */

class PaymentValidator {
    public boolean validateCardDetails(String cardNumber, String cvv, String expiryDate) {
        System.out.println("Validating card details");
        return true;
    }
}

class SecurityManager {
    public String encryptDate(String data) {
        System.out.println("Encrypting data");
        return "Encrypted data";
    }
}

class FraudDetector {
    public boolean checkForFraud(String transactionDetails) {
        System.out.println("Checking for fraud");
        return false;
    }
}

class PaymentProcessor {
    public boolean processCreditCard(String cardNumber, Double amount) {
        System.out.println("Processing payment");
        return true;
    }
}

class NotificationService {
    public void sendConfirmation(String email, String transactionId) {
        System.out.println("Sending Notification");
    }
}

interface PaymentFacade {
    public boolean processCreditCardPayment(String email, String cardNumber, String cvv, String expiryDate, Double amount);
}

class PaymentFacadeImpl implements PaymentFacade{
    private final PaymentValidator paymentValidator;
    private final SecurityManager securityManager;
    private final FraudDetector fraudDetector;
    private final PaymentProcessor paymentProcessor;
    private final NotificationService notificationService;

    // Dependency injected


    public PaymentFacadeImpl(PaymentValidator paymentValidator, SecurityManager securityManager, FraudDetector fraudDetector, PaymentProcessor paymentProcessor, NotificationService notificationService) {
        this.paymentValidator = paymentValidator;
        this.securityManager = securityManager;
        this.fraudDetector = fraudDetector;
        this.paymentProcessor = paymentProcessor;
        this.notificationService = notificationService;
    }

    @Override
    public boolean processCreditCardPayment(String email, String cardNumber, String cvv, String expiryDate, Double amount) {
        paymentValidator.validateCardDetails(cardNumber, cvv, expiryDate);

        securityManager.encryptDate("data");

        fraudDetector.checkForFraud("transaction details");

        paymentProcessor.processCreditCard(cardNumber, amount);

        notificationService.sendConfirmation(email, "transactionId");

        System.out.println("Payment Done");
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentValidator paymentValidator = new PaymentValidator();
        SecurityManager securityManager = new SecurityManager();
        FraudDetector fraudDetector = new FraudDetector();
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        NotificationService notificationService = new NotificationService();

        PaymentFacade paymentFacade = new PaymentFacadeImpl(paymentValidator, securityManager, fraudDetector, paymentProcessor, notificationService);

        paymentFacade.processCreditCardPayment("vikram.bedi97@gmail.com", "14699", "123","1023", 8004.10);
    }
}
