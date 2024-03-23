package com.lowleveldesign.splitwisedesign.split;

import java.util.List;

public class UnequalSplit implements ExpenseSplit {
    @Override
    public void validateSplitRequest(List<Split> splits, double amountDue) {
        double sum = 0.0d;
        for (Split splitValue : splits) {
            sum += splitValue.getAmountDue();
        }
        if (sum != amountDue) {
            throw new RuntimeException("UnequalSplit.validateSplitRequest: Invalid split value please check");
        }
    }
}
