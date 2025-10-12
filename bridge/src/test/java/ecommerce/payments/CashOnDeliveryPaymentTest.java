package ecommerce.payments;

import ecommerce.channels.NotificationChannel;
import ecommerce.channels.EmailChannel;
import ecommerce.channels.SmsChannel;
import ecommerce.channels.PushChannel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Red bar test for CashOnDeliveryPayment with Dependency Injection
 * Demonstrates Bridge pattern: different channels can be injected
 */
class CashOnDeliveryPaymentTest {

    @Test
    void testSendNotification_WithEmailChannel() {
        // Given - DI with EmailChannel
        NotificationChannel channel = new EmailChannel();
        CashOnDeliveryPayment notification = new CashOnDeliveryPayment(channel);
        String message = "Your order is out for delivery";

        // When
        String result = notification.notifyCustomer(message);

        // Then
        assertNotNull(result);
        assertTrue(result.contains("Cash on Delivery"));
        assertTrue(result.contains("Email"));
    }

    @Test
    void testSendNotification_WithSmsChannel() {
        // Given - DI with SmsChannel
        NotificationChannel channel = new SmsChannel();
        CashOnDeliveryPayment notification = new CashOnDeliveryPayment(channel);
        String message = "Your order is out for delivery";

        // When
        String result = notification.notifyCustomer(message);

        // Then
        assertNotNull(result);
        assertTrue(result.contains("Cash on Delivery"));
        assertTrue(result.contains("SMS"));
    }

    @Test
    void testSendNotification_WithPushChannel() {
        // Given - DI with PushChannel
        NotificationChannel channel = new PushChannel();
        CashOnDeliveryPayment notification = new CashOnDeliveryPayment(channel);
        String message = "Your order is out for delivery";

        // When
        String result = notification.notifyCustomer(message);

        // Then
        assertNotNull(result);
        assertTrue(result.contains("Cash on Delivery"));
        assertTrue(result.contains("Push"));
    }
}
