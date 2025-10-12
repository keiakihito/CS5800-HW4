package ecommerce.payments;

import ecommerce.channels.NotificationChannel;

/*
 * OnlinePaymentNotification class: Refined Abstraction
 */

public class OnlinePaymentNotification extends PaymentNotification {
    public OnlinePaymentNotification(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public String notifyCustomer(String message) {
        return getChannel().sendNotification("[Online Payment]: " + message);
    }
}