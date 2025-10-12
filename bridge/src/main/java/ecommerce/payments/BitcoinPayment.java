
package ecommerce.payments;

import ecommerce.channels.NotificationChannel;

/*
 * BitcoinPayment class: Refined Abstraction
 */

public class BitcoinPayment extends PaymentNotification {
    public BitcoinPayment(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public String notifyCustomer(String message) {
        return getChannel().sendNotification("[Bitcoin Payment]: " + message);
    }
}