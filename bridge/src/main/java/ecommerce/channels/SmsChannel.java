package ecommerce.channels;

public class SmsChannel implements NotificationChannel {
    @Override
    public String sendNotification(String message) {
        return "[SMS] " + message;
    }
}
