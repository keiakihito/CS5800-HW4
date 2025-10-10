package ecommerce.channels;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


class PushChannelTest {

    private PushChannel pushChannel;

    @BeforeEach
    void setUp() {
        pushChannel = new PushChannel();
    }

    @Test
    void testSendNotification_ShouldSendPushNotification() {
        // Given
        String message = "Your order has been confirmed";

        // When
        String result = pushChannel.sendNotification(message);

        // Then
        assertNotNull(result);
        assertTrue(result.contains("Push"));
    }
}
