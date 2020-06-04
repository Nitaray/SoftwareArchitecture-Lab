package edu.hcmiu.sa.user;

import edu.hcmiu.sa.core.WebServer;
import edu.hcmiu.sa.core.components.FormType;
import edu.hcmiu.sa.ui.WebUI;

public class FacultyStaff extends User{
    public void requestSoftwareInstallation() {
        new WebUI(new WebServer(), this).openRequestForm(FormType.SoftwareInstallation);
    }

    public void requestHardwareInstallation() {
        WebUI web = new WebUI(new WebServer(), this);
        web.openRequestForm(FormType.HardwareInstallation);
        web.clearDisplay();
    }

    public void requestHardwareRepair() {
        new WebUI(new WebServer(), this).openRequestForm(FormType.HardwareRepair);
    }

    public void requestSoftwareTraining() {
        new WebUI(new WebServer(), this).openRequestForm(FormType.SoftwareTraining);
    }
}
