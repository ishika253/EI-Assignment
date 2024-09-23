package ordersystem;
public class HomeDeliveryOrder extends OrderProcessTemplate {
    
    @Override
    protected void selectItem() {
        System.out.println("Selected item for home delivery.");
    }

    @Override
    protected void addToCart() {
        System.out.println("Added item to cart for delivery.");
    }

    @Override
    protected void checkout() {
        System.out.println("Checked out and payment processed for home delivery.");
    }

    @Override
    protected boolean isDelivery() {
        return true;  // Home delivery, so return true
    }
}
