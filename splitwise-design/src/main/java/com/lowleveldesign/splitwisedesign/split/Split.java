package com.lowleveldesign.splitwisedesign.split;


import com.lowleveldesign.splitwisedesign.user.User;

public class Split {
    private User user;
    private double amountDue;

    public Split(User user, double amountDue) {
        this.user = user;
        this.amountDue = amountDue;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmountDue() {
        return this.amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

}
