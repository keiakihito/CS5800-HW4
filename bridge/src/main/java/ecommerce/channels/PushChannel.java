package ecommerce.channels;

/*
 * PushChannel class: Concrete Implementor
 */
public class PushChannel implements NotificationChannel {
    @Override
    public String sendNotification(String message) {
        return "[Push] " + message;
    }
}
