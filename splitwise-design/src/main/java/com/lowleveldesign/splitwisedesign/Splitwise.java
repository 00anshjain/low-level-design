package com.lowleveldesign.splitwisedesign;

import com.lowleveldesign.splitwisedesign.enums.ExpenseSplitType;
import com.lowleveldesign.splitwisedesign.group.Group;
import com.lowleveldesign.splitwisedesign.group.GroupController;
import com.lowleveldesign.splitwisedesign.split.Split;
import com.lowleveldesign.splitwisedesign.user.User;
import com.lowleveldesign.splitwisedesign.user.UserController;

import java.util.ArrayList;
import java.util.List;

public class Splitwise {
    UserController userController;
    GroupController groupController;
    BalanceSheetController balanceSheetController;

    public Splitwise() {
        userController = new UserController();
        groupController = new GroupController();
        balanceSheetController = new BalanceSheetController();
    }

    public void demo() {
        setupUserAndGroup();

        //Step1: add members to the group
        Group group = groupController.getGroup("G1001");
        group.addMember(userController.getUser("U2001"));
        group.addMember(userController.getUser("U3001"));

        //Step2. create an expense inside a group
        List<Split> splits = new ArrayList<>();
        Split split1 = new Split(userController.getUser("U1001"), 300);
        Split split2 = new Split(userController.getUser("U2001"), 300);
        Split split3 = new Split(userController.getUser("U3001"), 300);
        splits.add(split1);
        splits.add(split2);
        splits.add(split3);
        group.createExpense("Exp1001", "Breakfast", 900, splits, ExpenseSplitType.EQUAL, userController.getUser("U1001"));

        List<Split> splits2 = new ArrayList<>();
        Split splits2_1 = new Split(userController.getUser("U1001"), 400);
        Split splits2_2 = new Split(userController.getUser("U2001"), 100);
        splits2.add(splits2_1);
        splits2.add(splits2_2);
        group.createExpense("Exp1002", "Lunch", 500, splits2, ExpenseSplitType.UNEQUAL, userController.getUser("U2001"));

        for (User user : userController.getAllUsers()) {
            balanceSheetController.showBalanceSheetOfUser(user);
        }
    }

    public void setupUserAndGroup() {
        addUsersToSplitwiseApp();
        User user1 = userController.getUser("U1001");
        groupController.createNewGroup("G1001", "Outing With Friends", user1);
    }

    void addUsersToSplitwiseApp() {
        User u1 = new User("U1001", "user1");
        User u2 = new User("U2001", "user2");
        User u3 = new User("U3001", "user3");

        userController.addUser(u1);
        userController.addUser(u2);
        userController.addUser(u3);
    }

}
