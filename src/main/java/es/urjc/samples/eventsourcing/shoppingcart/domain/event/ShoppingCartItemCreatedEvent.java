package es.urjc.samples.eventsourcing.shoppingcart.domain.event;

public class ShoppingCartItemCreatedEvent {

    String itemId;

    String cartId;

    String productId;

    int quantity;

    public ShoppingCartItemCreatedEvent() {
    }

    public ShoppingCartItemCreatedEvent(String itemId, String cartId, String productId, int quantity) {
        this.itemId = itemId;
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public String getCartId() {
        return cartId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

}
