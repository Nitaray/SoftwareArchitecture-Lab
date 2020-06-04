package edu.hcmiu.sa.ui;

import edu.hcmiu.sa.core.BudgetCalculator;
import edu.hcmiu.sa.user.User;
import edu.hcmiu.sa.ui.components.NoticeMessage;
import edu.hcmiu.sa.ui.components.UIObject;

import java.util.List;

public class BudgetCalculatorUI implements UI{
    private List<UIObject> onScreen;

    private BudgetCalculator budgetCalculator;

    private User caller;

    public BudgetCalculatorUI(User caller) {
        this.budgetCalculator = new BudgetCalculator();
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

    @Override
    public void close() {
        clearDisplay();
        onScreen.clear();
        onScreen = null;
        budgetCalculator = null;
        caller = null;
    }

    public void open() {
        budgetCalculator.initialize(this);
        String pricingInformation = caller.getInput();
        budgetCalculator.calculateCost(pricingInformation);
    }

    public void displayInsufficientBudget() {
        NoticeMessage insufficientNotice = new NoticeMessage("Insufficient Funds!");
        onScreen.add(insufficientNotice);
        display();
    }

    public void displaySufficientBudget() {
        NoticeMessage sufficientNotice = new NoticeMessage("Sufficient Funds!");
        onScreen.add(sufficientNotice);
        display();
    }

    public void displayRemainingBudget(float possibleRemainingBudget) {
        NoticeMessage remainingBudget = new NoticeMessage("If bought, remaining budget would be: " + possibleRemainingBudget);
        onScreen.add(remainingBudget);
        display();
    }

    public void displayStatsIfBought(float possibleRemainingBudget, float newIncome) {
        String message = String.format("If bought, remaining budget would be %.2f and new income would be %.2f.", possibleRemainingBudget, newIncome);
        NoticeMessage stats = new NoticeMessage(message);
        onScreen.add(stats);
        display();
    }
}
