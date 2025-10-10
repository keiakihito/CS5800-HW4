package ecommerce.channels;

/*
 * SmsChannel class: Concrete Implementor
 */
public class SmsChannel implements NotificationChannel {
    @Override
    public String sendNotification(String message) {
        return "[SMS] " + message;
    }
}
