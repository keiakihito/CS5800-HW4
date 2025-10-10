package ecommerce.payments;

import ecommerce.channels.NotificationChannel;

/*
 * PaymentNotification class: Abstraction
 */
public abstract class PaymentNotification {
    // Bridge which connects to the Implementor with DI.
    private NotificationChannel _channel;

    public PaymentNotification(NotificationChannel channel) {
        _channel = channel;
    }

    public abstract String notifyCustomer(String message);

    public NotificationChannel getChannel(){
        return _channel;
    }
    
        
}