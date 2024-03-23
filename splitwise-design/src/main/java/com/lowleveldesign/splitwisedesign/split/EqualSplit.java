package com.lowleveldesign.splitwisedesign.split;

import java.util.List;

public class EqualSplit implements ExpenseSplit {
    @Override
    public void validateSplitRequest(List<Split> splits, double amountDue) {
        double splitValue = amountDue / splits.size();
        for (Split split : splits) {
            if (split.getAmountDue() != splitValue) {
                throw new RuntimeException("EqualSplit.validateSplitRequest: Invalid Split. Check again");
            }
        }
    }
}
