package com.lowleveldesign.splitwisedesign.group;

import com.lowleveldesign.splitwisedesign.enums.ExpenseSplitType;
import com.lowleveldesign.splitwisedesign.expense.Expense;
import com.lowleveldesign.splitwisedesign.expense.ExpenseController;
import com.lowleveldesign.splitwisedesign.split.Split;
import com.lowleveldesign.splitwisedesign.user.User;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String groupId;
    String groupName;
    List<User> members;
    List<Expense> expenseList;
    ExpenseController expenseController;

    public Group() {
        members = new ArrayList<>();
        expenseList = new ArrayList<>();
        expenseController = new ExpenseController();
    }

    public void addMember(User user) {
        members.add(user);
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String id) {
        this.groupId = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getMembers() {
        return this.members;
    }

    public List<Expense> getExpenseList() {
        return this.expenseList;
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser) {
        Expense expense = expenseController.createExpense(expenseId, description, expenseAmount, splitDetails, splitType, paidByUser);
        expenseList.add(expense);
        return expense;
    }
}
