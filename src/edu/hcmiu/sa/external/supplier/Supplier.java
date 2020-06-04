package edu.hcmiu.sa.external.supplier;

public abstract class Supplier {
    public String addToCart(String productName) {
        String cartInfo = "";
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         */
        return cartInfo;
    }

    public void clearCart() {
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         */
    }

    public abstract String checkOutConfirm(String address, String billingInfo);
}
