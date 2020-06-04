package edu.hcmiu.sa.ui;

import edu.hcmiu.sa.core.WebServer;
import edu.hcmiu.sa.core.components.FormType;
import edu.hcmiu.sa.core.components.RequestForm;
import edu.hcmiu.sa.user.User;
import edu.hcmiu.sa.ui.components.RequestFormUI;
import edu.hcmiu.sa.ui.components.UIObject;
import edu.hcmiu.sa.ui.components.NoticeMessage;

import java.util.LinkedList;
import java.util.List;

public class WebUI implements UI{
    private WebServer server;
    private List<UIObject> onScreen;
    private User caller;

    public WebUI(WebServer server, User caller) {
        this.server = server;
        this.onScreen = new LinkedList<>();
        this.caller = caller;
    }

    @Override
    public void display() {
        onScreen.forEach(UIObject::show);
    }

    @Override
    public void clearDisplay() {
        onScreen.forEach(UIObject::hide);
        onScreen.clear();
    }

    public void openRequestForm(FormType type) {
        RequestForm requestForm = server.getRequestForm(type, this);
        String encodedInformation = caller.getInput();
        constructFormObject(requestForm, encodedInformation);
    }

    public void displayForm(RequestForm requestForm) {
        RequestFormUI requestFormUI = new RequestFormUI(requestForm);
        clearDisplay();
        addToScreen(requestFormUI);
        display();
    }

    private void displayInvalidFormNotice() {
        UIObject warning = new NoticeMessage("Entered information is invalid, please try again!");
        addToScreen(warning);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void displaySuccessNotice(RequestForm requestForm) {
        UIObject successNotice = new NoticeMessage("Your request has been successfully recorded! Please wait for responds!");
        addToScreen(successNotice);
        requestForm.close();
        display();
    }

    public void displayFailureNotice(RequestForm requestForm) {
        UIObject failureNotice = new NoticeMessage("Something went wrong! Please try again later!");
        addToScreen(failureNotice);
        requestForm.close();
        display();
    }

    @Override
    public void close() {
        clearDisplay();
        onScreen.clear();
        onScreen = null;
        server = null;
    }

    private void addToScreen(UIObject uiObject) {
        if (uiObject != null)
            onScreen.add(uiObject);
    }

    private void constructFormObject(RequestForm emptyForm, String encodedInformation) {
        RequestForm filledForm = emptyForm.fill(encodedInformation);
        while (!server.verifyForm(filledForm, this)) {
            resetForm(filledForm);
            displayInvalidFormNotice();
            displayForm(filledForm);
        }
    }

    private void resetForm(RequestForm filledForm) {
        filledForm.clear();
    }
}
