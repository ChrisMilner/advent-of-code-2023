package com.chrisdmilner.adventofcode.twentythree.day3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DayThreePartTwo extends DayThree {
    @Override
    int getSolution(char[][] lines) {
        int totalGearRatio = 0;

        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length; j++) {
                if (lines[i][j] == '*') {
                    List<Integer> labels = getLabels(lines, i, j);

                    if (labels.size() == 2) {
                        totalGearRatio += labels.get(0) * labels.get(1);
                    }
                }
            }
        }

        return totalGearRatio;
    }

    private List<Integer> getLabels(char[][] lines, int y, int x) {
        Set<Label> labels = new HashSet<>();

        int from = Math.max(0, x - 1);
        int to = Math.min(lines[0].length - 1, x + 1);

        // Above
        if (y > 0) {
            for (int i = from; i <= to; i++) {
                if (isNumber(lines[y - 1][i])) {
                    labels.add(getLabel(lines[y - 1], i, y - 1));
                }
            }
        }

        // Below
        if (y < lines.length - 1) {
            for (int i = from; i <= to; i++) {
                if (isNumber(lines[y + 1][i])) {
                    labels.add(getLabel(lines[y + 1], i, y + 1));
                }
            }
        }

        // Left
        if (x > 0) {
            if (isNumber(lines[y][x - 1])) {
                labels.add(getLabel(lines[y], x - 1, y));
            }
        }

        // Right
        if (x < lines[0].length - 1) {
            if (isNumber(lines[y][x + 1])) {
                labels.add(getLabel(lines[y], x + 1, y));
            }
        }

        return labels.stream().map(Label::number).toList();
    }

    private Label getLabel(char[] line, int i, int j) {
        // Expand left
        int startPoint = i;
        while (startPoint - 1 >= 0 && isNumber(line[startPoint - 1])) {
            startPoint--;
        }

        // Expand right
        int length = i - startPoint + 1;
        while (startPoint + length <= line.length - 1 && isNumber(line[startPoint + length])) {
            length++;
        }

        return new Label(startPoint, j, Integer.parseInt(new String(Arrays.copyOfRange(line, startPoint, startPoint + length))));
    }

    record Label(int xPos, int yPos, int number) {}
}
