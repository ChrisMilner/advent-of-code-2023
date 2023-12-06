package com.chrisdmilner.adventofcode.twentythree.day6;

import java.util.List;

public class DaySixPartOne extends DaySix {
    @Override
    long getSolution(List<Integer> times, List<Integer> distances) {
        long product = 1;

        for (int i = 0; i < times.size(); i++) {
            product *= solveQuadratic(-1, times.get(i), - distances.get(i)).streamLongsBetween().count();
        }

        return product;
    }
}
