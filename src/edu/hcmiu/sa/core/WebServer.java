package edu.hcmiu.sa.core;

import edu.hcmiu.sa.core.components.FormType;
import edu.hcmiu.sa.core.components.RequestForm;
import edu.hcmiu.sa.external.database.JDBCDriver;
import edu.hcmiu.sa.external.information.InformationSystem;
import edu.hcmiu.sa.external.information.InformationType;
import edu.hcmiu.sa.ui.WebUI;

public class WebServer {

    private InformationSystem informationSystem = new InformationSystem();
    private NotificationCenter notificationCenter = new NotificationCenter();
    private JDBCDriver jdbcDriver = new JDBCDriver();

    public RequestForm getRequestForm(FormType type, WebUI caller) {
        RequestForm form = new RequestForm(type);
        caller.displayForm(form);
        return form;
    }

    public boolean verifyForm(RequestForm filledForm, WebUI caller) {
        if (filledForm.checkMetaData()) {
            String SQLStatus;
            switch (filledForm.getType()) {
                case HardwareRepair:
                    String hardwareInformation = jdbcDriver.getHardwareInformation(filledForm);
                    SQLStatus = jdbcDriver.addRepairRequest(hardwareInformation);
                    finalizeRequest(SQLStatus, caller, filledForm);
                    break;
                case SoftwareTraining:
                    String softwareInformation = jdbcDriver.getSoftwareInformation(filledForm);
                    SQLStatus = jdbcDriver.addTrainingRequest(softwareInformation);
                    finalizeRequest(SQLStatus, caller, filledForm);
                    break;
                case HardwareInstallation:
                    String hardwarePrice = informationSystem.getInformation(InformationType.HARDWARE);
                    filledForm.addInfo(hardwarePrice);
                    SQLStatus = jdbcDriver.addToDatabase(filledForm);
                    finalizeRequest(SQLStatus, caller, filledForm);
                    break;
                case SoftwareInstallation:
                    String softwarePrice = informationSystem.getInformation(InformationType.SOFTWARE);
                    filledForm.addInfo(softwarePrice);
                    SQLStatus = new JDBCDriver().addToDatabase(filledForm);
                    finalizeRequest(SQLStatus, caller, filledForm);
                    break;
            }
            return true;
        }
        return false;
    }

    private void finalizeRequest(String sqlStatus, WebUI caller, RequestForm requestForm) {
        if (sqlStatus.equals("Success")) {
            notificationCenter.notifyNewRequest(requestForm);
            caller.displaySuccessNotice(requestForm);
        }
        else {
            notificationCenter.notifySystemError(requestForm);
            caller.displayFailureNotice(requestForm);
        }
    }
}
