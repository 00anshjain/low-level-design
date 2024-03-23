package com.lowleveldesign.splitwisedesign.expense;

import com.lowleveldesign.splitwisedesign.BalanceSheetController;
import com.lowleveldesign.splitwisedesign.enums.ExpenseSplitType;
import com.lowleveldesign.splitwisedesign.split.ExpenseSplit;
import com.lowleveldesign.splitwisedesign.split.Split;
import com.lowleveldesign.splitwisedesign.split.SplitFactory;
import com.lowleveldesign.splitwisedesign.user.User;

import java.util.List;

public class ExpenseController {
    private BalanceSheetController balanceSheetController;

    public ExpenseController() {
        this.balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double amount, List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser) {
        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
        expenseSplit.validateSplitRequest(splitDetails, amount);
        Expense expense = new Expense(expenseId, amount, description, paidByUser, splitType, splitDetails);
        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, amount);
        return expense;
    }
}
