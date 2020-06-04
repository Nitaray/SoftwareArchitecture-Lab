package edu.hcmiu.sa.ui;

import edu.hcmiu.sa.core.SocialNetworkManager;
import edu.hcmiu.sa.ui.components.NoticeMessage;
import edu.hcmiu.sa.user.User;
import edu.hcmiu.sa.ui.components.UIObject;

import java.util.LinkedList;
import java.util.List;

public class SocialNetworkManagerUI implements UI {
    private List<UIObject> onScreen;

    private User caller;

    private SocialNetworkManager socialNetworkManager;

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
        socialNetworkManager = null;
        caller = null;
    }

    public SocialNetworkManagerUI(User caller) {
        onScreen = new LinkedList<>();
        this.caller = caller;
        socialNetworkManager = new SocialNetworkManager();
    }

    public void createNewPromotion() {
        socialNetworkManager.initialize(this);
        String classInfo = caller.getInput();
        socialNetworkManager.makeNewPromotion(classInfo);
    }

    public void displayPromotionLinks(String promotionLink) {
        NoticeMessage prMessage = new NoticeMessage("Social network link created: " + promotionLink);
        onScreen.add(prMessage);
        display();
    }
}
