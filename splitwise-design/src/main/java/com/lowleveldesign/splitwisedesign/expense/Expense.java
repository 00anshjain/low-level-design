package com.lowleveldesign.splitwisedesign.expense;

import com.lowleveldesign.splitwisedesign.enums.ExpenseSplitType;
import com.lowleveldesign.splitwisedesign.split.Split;
import com.lowleveldesign.splitwisedesign.user.User;

import java.util.List;

public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    User paidByUser;
    ExpenseSplitType splitType;
    List<Split> splitDetails;

    public Expense(String expenseId, double expenseAmount, String description,
                   User paidByUser, ExpenseSplitType splitType, List<Split> splitDetails) {

        this.expenseId = expenseId;
        this.expenseAmount = expenseAmount;
        this.description = description;
        this.paidByUser = paidByUser;
        this.splitType = splitType;
        this.splitDetails = splitDetails;

    }

}

