package ecommerce.channels;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


class EmailChannelTest {

    private EmailChannel emailChannel;

    @BeforeEach
    void setUp() {
        emailChannel = new EmailChannel();
    }

    @Test
    void testSendNotification_ShouldSendEmail() {
        // Given
        String message = "Your order has been confirmed. Thank you.";

        // When
        String result = emailChannel.sendNotification(message);

        // Then
        assertNotNull(result);
        assertTrue(result.contains("Email"));
    }
}
