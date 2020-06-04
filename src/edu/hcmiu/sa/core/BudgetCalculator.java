package edu.hcmiu.sa.core;

import edu.hcmiu.sa.core.components.Budget;
import edu.hcmiu.sa.ui.BudgetCalculatorUI;

public class BudgetCalculator {
    private Budget budget;

    private BudgetCalculatorUI caller;

    public void initialize(BudgetCalculatorUI caller) {
        budget = new Budget();
        this.caller = caller;
        caller.display();
    }

    public void calculateCost(String pricingInformation) {
        float totalBudget = budget.getTotalBudget();
        float price = parseFloat(pricingInformation);
        String type = parseType(pricingInformation);
        float possibleRemainingBudget = calculatePossibleRemainingBudget(totalBudget, price);
        if (possibleRemainingBudget <= 0) {
            caller.displayInsufficientBudget();
        } else {
            caller.displaySufficientBudget();
            if (type.equals("ONE-TIME")) {
                caller.displayRemainingBudget(possibleRemainingBudget);
            } else {
                float income = budget.getIncome();
                float subFee = parseSubscriptionFee(pricingInformation);
                int subscriptionPeriod = parseSubscriptionPeriod(pricingInformation);
                float newIncome = calculateIncomeSubtractSubscriptionFee(income, subFee, subscriptionPeriod);
                caller.displayStatsIfBought(possibleRemainingBudget, newIncome);
            }
        }
    }

    private float calculateIncomeSubtractSubscriptionFee(float income, float subFee, int subscriptionPeriod) {
        return income - subFee / subscriptionPeriod;
    }

    private float calculatePossibleRemainingBudget(float totalBudget, float price) {
        return totalBudget - price;
    }

    private float parseSubscriptionFee(String pricingInformation) {
        float subscriptionFee = 0.0f;
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         */
        return subscriptionFee;
    }

    private int parseSubscriptionPeriod(String pricingInformation) {
        int months = 1;
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         */
        return months;
    }

    private float parseFloat(String pricingInformation) {
        float price = 0.0f;
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         */
        return price;
    }

    private String parseType(String pricingInformation) {
        String type = "ONE-TIME";
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         */
        return type;
    }
}
