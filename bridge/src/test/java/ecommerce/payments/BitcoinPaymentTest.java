package ecommerce.payments;

import ecommerce.channels.NotificationChannel;
import ecommerce.channels.EmailChannel;
import ecommerce.channels.SmsChannel;
import ecommerce.channels.PushChannel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for BitcoinPayment with Dependency Injection
 * Demonstrates Bridge pattern: different channels can be injected
 */
class BitcoinPaymentTest {

    @Test
    void testSendNotification_WithEmailChannel() {
        // Given - DI with EmailChannel
        NotificationChannel channel = new EmailChannel();
        BitcoinPayment notification = new BitcoinPayment(channel);
        String message = "Bitcoin payment confirmed";

        // When
        String result = notification.notifyCustomer(message);

        // Then
        assertNotNull(result);
        assertTrue(result.contains("Bitcoin"));
        assertTrue(result.contains("Email"));
    }

    @Test
    void testSendNotification_WithSmsChannel() {
        // Given - DI with SmsChannel
        NotificationChannel channel = new SmsChannel();
        BitcoinPayment notification = new BitcoinPayment(channel);
        String message = "Bitcoin payment confirmed";

        // When
        String result = notification.notifyCustomer(message);

        // Then
        assertNotNull(result);
        assertTrue(result.contains("Bitcoin"));
        assertTrue(result.contains("SMS"));
    }

    @Test
    void testSendNotification_WithPushChannel() {
        // Given - DI with PushChannel
        NotificationChannel channel = new PushChannel();
        BitcoinPayment notification = new BitcoinPayment(channel);
        String message = "Bitcoin payment confirmed";

        // When
        String result = notification.notifyCustomer(message);

        // Then
        assertNotNull(result);
        assertTrue(result.contains("Bitcoin"));
        assertTrue(result.contains("Push"));
    }
}
