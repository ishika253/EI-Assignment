package notificationfactory;

public class SMSNotification implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS Notification: " + message);
    }
}
