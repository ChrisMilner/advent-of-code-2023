package com.chrisdmilner.adventofcode.twentythree.day14;

import java.util.List;

public class DayFourteenPartOne extends DayFourteen {
    @Override
    long getLoad(List<List<Rock>> rockCols) {
        return rockCols.stream()
                .mapToInt(this::getLoadForColumn)
                .sum();
    }

    private int getLoadForColumn(List<Rock> column) {
        int load = 0;
        int ceiling = column.size();

        for (int i = 0; i < column.size(); i++) {
            switch (column.get(i)) {
                case ROUNDED -> {
                    load += ceiling;
                    ceiling--;
                }
                case CUBE -> ceiling = column.size() - i - 1;
            }
        }

        return load;
    }
}
