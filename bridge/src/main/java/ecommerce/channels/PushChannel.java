package ecommerce.channels;

public class PushChannel implements NotificationChannel {
    @Override
    public String sendNotification(String message) {
        return "[Push] " + message;
    }
}
