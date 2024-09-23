package ordersystem;

public class Main {
    public static void main(String[] args) {
        // Home Delivery Order
        System.out.println("Processing Home Delivery Order:");
        OrderProcessTemplate homeDeliveryOrder = new HomeDeliveryOrder();
        homeDeliveryOrder.processOrder();  // Execute the template method

        System.out.println("\nProcessing Store Pickup Order:");
        // Store Pickup Order
        OrderProcessTemplate storePickupOrder = new StorePickupOrder();
        storePickupOrder.processOrder();  // Execute the template method
    }
}
