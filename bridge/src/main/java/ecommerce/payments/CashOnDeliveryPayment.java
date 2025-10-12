package ecommerce.payments;

import ecommerce.channels.NotificationChannel;

/*
 * CashOnDeliveryPayment class: Refined Abstraction
 */


 public class CashOnDeliveryPayment extends PaymentNotification {
    public CashOnDeliveryPayment(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public String notifyCustomer(String message) {
        return getChannel().sendNotification("[Cash on Delivery]: " + message);
    }
}