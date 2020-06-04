package edu.hcmiu.sa.core;

import edu.hcmiu.sa.external.network.ExternalEmailSystem;
import edu.hcmiu.sa.external.network.ExternalSocialNetwork;
import edu.hcmiu.sa.ui.SocialNetworkManagerUI;

public class SocialNetworkManager {
    private SocialNetworkManagerUI caller;

    public void initialize(SocialNetworkManagerUI caller) {
        this.caller = caller;
        caller.display();
    }

    public void makeNewPromotion(String classInfo) {
        ExternalSocialNetwork externalSocialNetwork = new ExternalSocialNetwork();
        ExternalEmailSystem externalEmailSystem = new ExternalEmailSystem();
        String promotionLink = externalSocialNetwork.createPost(classInfo);
        externalEmailSystem.sendMail(classInfo);
        caller.displayPromotionLinks(promotionLink);
    }
}
