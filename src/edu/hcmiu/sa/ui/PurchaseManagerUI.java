package edu.hcmiu.sa.ui;

import edu.hcmiu.sa.core.PurchaseManager;
import edu.hcmiu.sa.external.information.InformationType;
import edu.hcmiu.sa.ui.components.NoticeMessage;
import edu.hcmiu.sa.ui.components.UIObject;
import edu.hcmiu.sa.user.User;

import java.util.LinkedList;
import java.util.List;

public class PurchaseManagerUI implements UI{
    private List<UIObject> onScreen;

    private PurchaseManager purchaseManager;

    private User caller;

    @Override
    public void display() {
        onScreen.forEach(UIObject::show);
    }

    @Override
    public void clearDisplay() {
        onScreen.forEach(UIObject::hide);
        onScreen.clear();
    }

    @Override
    public void close() {
        clearDisplay();
        onScreen = null;
        purchaseManager = null;
        caller = null;
    }

    public PurchaseManagerUI(User caller) {
        onScreen = new LinkedList<>();
        purchaseManager = new PurchaseManager();
        this.caller = caller;
    }

    public void createNewPurchase(InformationType type) {
        purchaseManager.initialize(this);

        String productName = caller.getInput();
        String supplier = caller.getInput();
        String cartInfo = purchaseManager.makePurchase(productName, supplier, type);

        displayConfirmPrompt(cartInfo);
        boolean confirmation = (caller.getInput().toLowerCase().equals("yes"));
        if (confirmation)
            purchaseManager.confirmPurchase(cartInfo, type);
        else
            purchaseManager.removePurcase(cartInfo, type);
    }

    private void displayConfirmPrompt(String cartInfo) {
        NoticeMessage confirm = new NoticeMessage("Do you want to check out with this cart: " + cartInfo);
        onScreen.add(confirm);
        display();
    }
}
