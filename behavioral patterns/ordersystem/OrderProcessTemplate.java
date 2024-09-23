package ordersystem;
public abstract class OrderProcessTemplate {
    
    // Template method defining the skeleton of the algorithm.
    public final void processOrder() {
        selectItem();
        addToCart();
        checkout();
        if (isDelivery()) {
            arrangeDelivery();
        } else {
            pickupAtStore();
        }
    }

    // Abstract methods that will be implemented by concrete classes.
    protected abstract void selectItem();
    protected abstract void addToCart();
    protected abstract void checkout();

    // Hook methods: Subclasses can override these if needed.
    protected boolean isDelivery() {
        return true;  // Default is delivery; subclasses can override
    }

    // Common methods for delivery or pickup.
    protected void arrangeDelivery() {
        System.out.println("Arranging delivery to your address.");
    }

    protected void pickupAtStore() {
        System.out.println("Your order is ready for pickup at the store.");
    }
}
