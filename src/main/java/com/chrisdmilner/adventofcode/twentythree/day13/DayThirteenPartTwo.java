package com.chrisdmilner.adventofcode.twentythree.day13;

import com.chrisdmilner.adventofcode.twentythree.common.MathsUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class DayThirteenPartTwo extends DayThirteen {
    int findReflectionPoint(List<Integer> rows) {
        Set<Integer> rowSet = new HashSet<>(rows);
        List<Integer> powersOfTwo = MathsUtils.powersOfTwoUpTo(rows.stream().mapToInt(i -> i).max().orElse(0));

        for (int i = 0; i < rows.size(); i++) {
            for (int power : powersOfTwo) {
                if ((rows.get(i) & power) != 0) {
                    continue;
                }

                int rowPlusPower = rows.get(i) + power;

                if (rowSet.contains(rowPlusPower)) {
                    List<Integer> reflectedRows = IntStream.range(0, rows.size())
                            .filter(index -> rows.get(index).equals(rowPlusPower))
                            .boxed()
                            .toList();

                    for (int reflectedRow : reflectedRows) {
                        int difference = Math.abs(reflectedRow - i) + 1;

                        if (difference % 2 == 1) {
                            continue;
                        }

                        int centrePoint = Math.min(i, reflectedRow) + (difference / 2);

                        if (isReflectedAt(copyAndUpdateValue(rows, i, rowPlusPower), centrePoint)) {
                            return centrePoint;
                        }
                    }
                }
            }
        }

        return 0;
    }

    private List<Integer> copyAndUpdateValue(List<Integer> list, int index, int newValue) {
        List<Integer> newList = new ArrayList<>(list);
        newList.set(index, newValue);

        return newList;
    }
}
