package ecommerce.channels;

/*
 * EmailChannel class: Concrete Implementor
 */
public class EmailChannel implements NotificationChannel {
    @Override
    public String sendNotification(String message) {
        return "[Email] " + message;
    }
}