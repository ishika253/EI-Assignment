package notificationfactory;

public class Main {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        // Send Email Notification
        Notification emailNotification = factory.createNotification("email");
        emailNotification.sendNotification("This is an email notification!");

        // Send SMS Notification
        Notification smsNotification = factory.createNotification("sms");
        smsNotification.sendNotification("This is an SMS notification!");

        // Send Push Notification
        Notification pushNotification = factory.createNotification("push");
        pushNotification.sendNotification("This is a push notification!");
    }
}
