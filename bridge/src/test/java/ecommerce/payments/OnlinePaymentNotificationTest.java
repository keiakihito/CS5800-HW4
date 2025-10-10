package ecommerce.payments;

import ecommerce.channels.EmailChannel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Red bar test for OnlinePaymentNotification implementation
 */
class OnlinePaymentNotificationTest {

    private OnlinePaymentNotification notification;
    private EmailChannel emailChannel;

    @BeforeEach
    void setUp() {
        // Dependencies Injection for OnlinePaymentNotification and EmailChannel
        emailChannel = new EmailChannel();
        notification = new OnlinePaymentNotification(emailChannel);
    }

    @Test
    void testSendNotification_ShouldSendOnlinePaymentNotification() {
        // Given
        String message = "Payment received";

        // When
        String result = notification.notifyCustomer(message);

        // Then
        assertNotNull(result);
        assertTrue(result.contains("Online Payment"));
    }
}
