package notificationfactory;

public class PushNotification implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}
