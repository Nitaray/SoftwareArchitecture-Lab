package edu.hcmiu.sa.user;

import edu.hcmiu.sa.ui.CompatibilityCheckerUI;

public class SoftwareExpert extends User {
    public void CheckSoftwareCompatibility() {
        new CompatibilityCheckerUI(this).open();
    }
}
