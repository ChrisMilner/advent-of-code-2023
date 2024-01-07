package com.chrisdmilner.adventofcode.twentythree.day13;

import java.util.List;

public class DayThirteenPartOne extends DayThirteen {
    int findReflectionPoint(List<Integer> rows) {
        for (int i = 1; i < rows.size(); i++) {
            if (isReflectedAt(rows, i)) {
                return i;
            }
        }

        return 0;
    }
}
