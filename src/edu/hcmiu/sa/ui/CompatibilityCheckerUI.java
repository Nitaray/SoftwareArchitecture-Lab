package edu.hcmiu.sa.ui;

import edu.hcmiu.sa.core.CompatibilityChecker;
import edu.hcmiu.sa.user.User;
import edu.hcmiu.sa.ui.components.NoticeMessage;
import edu.hcmiu.sa.ui.components.UIObject;

import java.util.LinkedList;
import java.util.List;

public class CompatibilityCheckerUI implements UI{
    private List<UIObject> onScreen;

    private CompatibilityChecker compatibilityChecker;
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
        compatibilityChecker = null;
        caller = null;
    }

    public CompatibilityCheckerUI(User caller) {
        onScreen = new LinkedList<>();
        compatibilityChecker = new CompatibilityChecker();
        this.caller = caller;
    }

    public void open() {
        compatibilityChecker.initialize(this);
        String hardwareName = caller.getInput();
        String softwareName = caller.getInput();
        compatibilityChecker.checkCompatibility(hardwareName, softwareName);
    }

    public void displayCompatible() {
        NoticeMessage compatible = new NoticeMessage("The software is compatible with this hardware!");
        onScreen.add(compatible);
        display();
    }

    public void displayIncompatible() {
        NoticeMessage incompatible = new NoticeMessage("The software is incompatible with this hardware!");
        onScreen.add(incompatible);
        display();
    }
}
