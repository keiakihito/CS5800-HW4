package ecommerce.channels;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


class SmsChannelTest {

    private SmsChannel smsChannel;

    @BeforeEach
    void setUp() {
        smsChannel = new SmsChannel();
    }

    @Test
    void testSendNotification_ShouldSendSms() {
        // Given
        String message = "Your order has been confirmed";

        // When
        String result = smsChannel.sendNotification(message);

        // Then
        assertNotNull(result);
        assertTrue(result.contains("SMS"));
    }
}
