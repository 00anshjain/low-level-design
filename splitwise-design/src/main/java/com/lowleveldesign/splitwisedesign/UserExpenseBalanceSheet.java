package com.lowleveldesign.splitwisedesign;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    Map<String, Balance> userVsBalance;
    double totalYourExpense;
    double totalPayment;
    double totalOwe;
    double totalYouGetBack;

    public UserExpenseBalanceSheet() {
        userVsBalance = new HashMap<>();
        totalYourExpense = 0;
        totalPayment = 0;
        totalOwe = 0;
        totalYouGetBack = 0;
    }

    Map<String, Balance> getUserVsBalance() {
        return userVsBalance;
    }

    double getTotalYourExpense() {
        return this.totalYourExpense;
    }

    void setTotalYourExpense(double value) {
        this.totalYourExpense = value;
    }

    double getTotalPayment() {
        return this.totalPayment;
    }

    void setTotalPayment(double value) {
        this.totalPayment = value;
    }

    double getTotalOwe() {
        return this.totalOwe;
    }

    void setTotalOwe(double value) {
        this.totalOwe = value;
    }

    double getTotalYouGetBack() {
        return this.totalYouGetBack;
    }

    void setTotalYouGetBack(double value) {
        this.totalYouGetBack = value;
    }
}
