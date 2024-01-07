package com.chrisdmilner.adventofcode.twentythree.day13;

import java.util.List;

public class DayThirteenPartOne extends DayThirteen {
    @Override
    long getReflectionPoint(List<Integer> rows, List<Integer> cols) {
        System.out.println(rows);
        System.out.println(cols);

        int rowsReflectionPoint = findReflectionPoint(rows);

        if (rowsReflectionPoint > 0) {
            return rowsReflectionPoint * 100L;
        }

        return findReflectionPoint(cols);
    }

    private int findReflectionPoint(List<Integer> rows) {
        for (int i = 1; i < rows.size(); i++) {
            if (isReflectedAt(rows, i)) {
                return i;
            }
        }

        return -1;
    }

    private boolean isReflectedAt(List<Integer> rows, int i) {
        int range = 1;

        while (i - range >= 0 && i + range - 1 < rows.size()) {
            if (!rows.get(i - range).equals(rows.get(i + range - 1))) {
                return false;
            }

            range++;
        }

        return true;
    }
}
