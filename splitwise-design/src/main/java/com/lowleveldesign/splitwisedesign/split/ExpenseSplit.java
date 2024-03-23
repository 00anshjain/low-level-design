package com.lowleveldesign.splitwisedesign.split;

import java.util.List;

public interface ExpenseSplit {
    public void validateSplitRequest(List<Split> splits, double amountDue);
}
