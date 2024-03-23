package com.lowleveldesign.splitwisedesign;

import com.lowleveldesign.splitwisedesign.split.Split;
import com.lowleveldesign.splitwisedesign.user.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {
    public void updateUserExpenseBalanceSheet(User expensePaidBy, List<Split> splits, double totalExpenseAmount) {
        UserExpenseBalanceSheet paidByUserExpenseSheet = expensePaidBy.getUserExpenseBalanceSheet();
        paidByUserExpenseSheet.setTotalPayment(paidByUserExpenseSheet.getTotalPayment() + totalExpenseAmount);

        for (Split split : splits) {
            User oweUser = split.getUser();
            if (oweUser.getUserId().equals(expensePaidBy.getUserId())) {
                paidByUserExpenseSheet.setTotalYourExpense(paidByUserExpenseSheet.getTotalYourExpense() + split.getAmountDue());
            } else {
                //update the balance of paid user
                paidByUserExpenseSheet.setTotalYouGetBack(paidByUserExpenseSheet.getTotalYouGetBack() + split.getAmountDue());
                Balance userOweBalance;
                if (paidByUserExpenseSheet.getUserVsBalance().containsKey(oweUser.getUserId())) {
                    userOweBalance = paidByUserExpenseSheet.getUserVsBalance().get(oweUser.getUserId());
                    userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack() + split.getAmountDue());
                } else {
                    userOweBalance = new Balance(0d, split.getAmountDue());
                }
                paidByUserExpenseSheet.getUserVsBalance().put(oweUser.getUserId(), userOweBalance);

                //update the balance sheet of owe user
                UserExpenseBalanceSheet oweUserExpenseSheet = oweUser.getUserExpenseBalanceSheet();
                oweUserExpenseSheet.setTotalYourExpense(oweUserExpenseSheet.getTotalYourExpense() + split.getAmountDue());
                oweUserExpenseSheet.setTotalOwe(oweUserExpenseSheet.getTotalOwe() + split.getAmountDue());
                Balance userPaidBalance;
                if (oweUserExpenseSheet.getUserVsBalance().containsKey(expensePaidBy.getUserId())) {
                    userPaidBalance = oweUserExpenseSheet.getUserVsBalance().get(expensePaidBy.getUserId());
                    userPaidBalance.setAmountOwe(userPaidBalance.getAmountOwe() + split.getAmountDue());
                } else {
                    userPaidBalance = new Balance(split.getAmountDue(), 0d);
                }
                oweUserExpenseSheet.getUserVsBalance().put(expensePaidBy.getUserId(), userPaidBalance);
            }
        }
    }

    public void showBalanceSheetOfUser(User user) {

        System.out.println("---------------------------------------");

        System.out.println("Balance sheet of user : " + user.getUserId());

        UserExpenseBalanceSheet userExpenseBalanceSheet = user.getUserExpenseBalanceSheet();

        System.out.println("TotalYourExpense: " + userExpenseBalanceSheet.getTotalYourExpense());
        System.out.println("TotalGetBack: " + userExpenseBalanceSheet.getTotalYouGetBack());
        System.out.println("TotalYourOwe: " + userExpenseBalanceSheet.getTotalOwe());
        System.out.println("TotalPaymentMade: " + userExpenseBalanceSheet.getTotalPayment());
        for (Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()) {

            String userID = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("userID:" + userID + " YouGetBack:" + balance.getAmountGetBack() + " YouOwe:" + balance.getAmountOwe());
        }

        System.out.println("---------------------------------------");

    }
}
