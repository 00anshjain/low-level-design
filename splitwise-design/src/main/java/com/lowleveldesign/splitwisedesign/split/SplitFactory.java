package com.lowleveldesign.splitwisedesign.split;

import com.lowleveldesign.splitwisedesign.enums.ExpenseSplitType;

public class SplitFactory {
    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType) {
        if (splitType.equals(ExpenseSplitType.EQUAL)) {
            return new EqualSplit();
        } else if (splitType.equals(ExpenseSplitType.UNEQUAL)) {
            return new UnequalSplit();
        }
        return null;
    }
}
