package com.chrisdmilner.adventofcode.twentythree.day19;

import com.chrisdmilner.adventofcode.twentythree.common.utils.ListUtils;

import java.util.List;

public class DayNineteenPartTwo extends DayNineteen {
    @Override
    long getSolution(Workflows workflows, List<Part> parts) {
        List<Integer> xTransitions = workflows.getAllTransitionPoints('x');
        List<Integer> mTransitions = workflows.getAllTransitionPoints('m');
        List<Integer> aTransitions = workflows.getAllTransitionPoints('a');
        List<Integer> sTransitions = workflows.getAllTransitionPoints('s');

        long acceptedCombinations = 0;

        for (int x = 0; x < xTransitions.size(); x++) {
            System.out.println(x);
            for (int m = 0; m < mTransitions.size(); m++) {
                for (int a = 0; a < aTransitions.size(); a++) {
                    for (int s = 0; s < sTransitions.size(); s++) {
                        int xVal = xTransitions.get(x);
                        int mVal = mTransitions.get(m);
                        int aVal = aTransitions.get(a);
                        int sVal = sTransitions.get(s);

                        if (workflows.shouldAccept(new Part(xVal, mVal, aVal, sVal))) {
                            long nextX = ListUtils.getOrElse(xTransitions, x + 1, 4001);
                            long nextM = ListUtils.getOrElse(mTransitions, m + 1, 4001);
                            long nextA = ListUtils.getOrElse(aTransitions, a + 1, 4001);
                            long nextS = ListUtils.getOrElse(sTransitions, s + 1, 4001);

                            acceptedCombinations += (nextX - xVal)
                                    * (nextM - mVal)
                                    * (nextA - aVal)
                                    * (nextS - sVal);
                        }
                    }
                }
            }
        }

        return acceptedCombinations;
    }
}
