package edu.hcmiu.sa.core;

import edu.hcmiu.sa.external.information.InformationType;
import edu.hcmiu.sa.external.supplier.HardwareSupplierServer;
import edu.hcmiu.sa.external.supplier.SoftwareSupplierServer;
import edu.hcmiu.sa.ui.PurchaseManagerUI;

public class PurchaseManager {
    private static final String address = "ABC";
    private static final String billingInfo = "XYZ";

    private PurchaseManagerUI caller;

    private HardwareSupplierServer hss;
    private SoftwareSupplierServer sss;

    public void initialize(PurchaseManagerUI caller) {
        this.caller = caller;
        caller.display();
    }

    public String makePurchase(String productName, String supplier, InformationType type) {
        String cartInfo = "";
        switch (type) {
            case HARDWARE:
                hss = new HardwareSupplierServer(supplier);
                cartInfo = hss.addToCart(productName);
                break;
            case SOFTWARE:
                sss = new SoftwareSupplierServer(supplier);
                cartInfo = sss.addToCart(productName);
                break;
        }
        return cartInfo;
    }

    public void confirmPurchase(String cartInfo, InformationType type) {
        switch (type) {
            case SOFTWARE:
                sss.checkOutConfirm(address, billingInfo);
                break;
            case HARDWARE:
                hss.checkOutConfirm(address, billingInfo);
                break;
        }
    }

    public void removePurcase(String cartInfo, InformationType type) {
        switch (type) {
            case HARDWARE:
                hss.clearCart();
                break;
            case SOFTWARE:
                sss.clearCart();
                break;
        }
    }
}
