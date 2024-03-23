package com.lowleveldesign.splitwisedesign;

public class Balance {
    double amountOwe;
    double amountGetBack;

    public Balance(double amountOwe, double amountGetBack) {
        this.amountOwe = amountOwe;
        this.amountGetBack = amountGetBack;
    }

    public double getAmountOwe() {
        return this.amountOwe;
    }

    public void setAmountOwe(double value) {
        this.amountOwe = value;
    }

    public double getAmountGetBack() {
        return this.amountGetBack;
    }

    public void setAmountGetBack(double value) {
        this.amountGetBack = value;
    }


}
