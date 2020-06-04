package edu.hcmiu.sa.user;

import edu.hcmiu.sa.ui.BudgetCalculatorUI;

public class FinancialAnalyst extends User {
    public void calculateBudget() {
        new BudgetCalculatorUI(this).open();
    }
}
