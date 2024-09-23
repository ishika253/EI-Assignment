package ordersystem;

public class StorePickupOrder extends OrderProcessTemplate {

    @Override
    protected void selectItem() {
        System.out.println("Selected item for store pickup.");
    }

    @Override
    protected void addToCart() {
        System.out.println("Added item to cart for store pickup.");
    }

    @Override
    protected void checkout() {
        System.out.println("Checked out and payment processed for store pickup.");
    }

    @Override
    protected boolean isDelivery() {
        return false;  // Pickup from store, so return false
    }
}
