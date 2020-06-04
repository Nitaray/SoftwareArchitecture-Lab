package edu.hcmiu.sa.user;

import edu.hcmiu.sa.external.information.InformationType;
import edu.hcmiu.sa.ui.PurchaseManagerUI;

public class InventoryManager extends User {

    public void purchaseHardware() {
        new PurchaseManagerUI(this).createNewPurchase(InformationType.HARDWARE);
    }

    public void purchaseSoftware() {
        new PurchaseManagerUI(this).createNewPurchase(InformationType.SOFTWARE);
    }
}
