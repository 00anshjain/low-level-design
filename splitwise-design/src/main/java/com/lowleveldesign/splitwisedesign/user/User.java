package com.lowleveldesign.splitwisedesign.user;

import com.lowleveldesign.splitwisedesign.UserExpenseBalanceSheet;

public class User {
    String userId;
    String name;
    UserExpenseBalanceSheet userExpenseBalanceSheet;

    public User(String id, String name) {
        this.userId = id;
        this.name = name;
        this.userExpenseBalanceSheet = new UserExpenseBalanceSheet();
    }

    public String getUserId() {
        return this.userId;
    }

    public String getName() {
        return this.name;
    }

    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return this.userExpenseBalanceSheet;
    }

}
