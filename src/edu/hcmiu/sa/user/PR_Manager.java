package edu.hcmiu.sa.user;

import edu.hcmiu.sa.ui.SocialNetworkManagerUI;

public class PR_Manager extends User {
    public void PromoteClass() {
        new SocialNetworkManagerUI(this).createNewPromotion();
    }
}
