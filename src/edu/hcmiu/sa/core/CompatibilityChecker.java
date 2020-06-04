package edu.hcmiu.sa.core;

import edu.hcmiu.sa.ui.CompatibilityCheckerUI;

import java.util.List;

public class CompatibilityChecker {
    private CompatibilityCheckerUI caller;

    private SoftwareManager softwareManager;

    public void initialize(CompatibilityCheckerUI caller) {
        this.caller = caller;
        softwareManager = new SoftwareManager();
        caller.display();
    }

    public void checkCompatibility(String hardwareName, String softwareName) {
        boolean isCompatible = false;
        List<String> compatibleList = softwareManager.getSoftwareCompatibilityList(softwareName);
        for (String compatible : compatibleList) {
            if (compatible.equals(hardwareName))
                isCompatible = true;
        }
        if (isCompatible)
            caller.displayCompatible();
        else
            caller.displayIncompatible();
    }
}
