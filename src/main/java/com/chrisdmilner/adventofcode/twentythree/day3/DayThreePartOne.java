package com.chrisdmilner.adventofcode.twentythree.day3;

import java.util.Set;

public class DayThreePartOne extends DayThree {
    private static final Set<Character> NUMBERS = Set.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
    private static final Set<Character> NOT_SYMBOL = Set.of('.', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    @Override
    int getSolution(char[][] lines) {
        int totalLabels = 0;

        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length; j++) {
                if (isNumber(lines[i][j])) {
                    String numberString = findFullNumber(lines[i], j);
                    int numberLength = numberString.length();

                    if (labelHasSymbol(lines, i, j, numberLength)) {
                        totalLabels += Integer.parseInt(numberString);
                    }

                    j += numberLength - 1;
                }
            }
        }

        return totalLabels;
    }

    private String findFullNumber(char[] line, int start) {
        StringBuilder numberString = new StringBuilder("" + line[start]);
        int numberLength = 1;

        while (start + numberLength < line.length && isNumber(line[start + numberLength])) {
            numberString.append(line[start + numberLength]);
            numberLength++;
        }

        return numberString.toString();
    }

    private boolean labelHasSymbol(char[][] lines, int numberLine, int numberStart, int numberLength) {
        // Check Above
        if (numberLine - 1 >= 0) {
            int from = Math.max(0, numberStart - 1);
            int to = Math.min(lines[numberLine - 1].length - 1, numberStart + numberLength);

            for (int i = from; i <= to; i++) {
                if (isSymbol(lines[numberLine - 1][i])) {
                    return true;
                }
            }
        }

        // Check Below
        if (numberLine + 1 < lines.length) {
            int from = Math.max(0, numberStart - 1);
            int to = Math.min(lines[numberLine + 1].length - 1, numberStart + numberLength);

            for (int i = from; i <= to; i++) {
                if (isSymbol(lines[numberLine + 1][i])) {
                    return true;
                }
            }
        }

        // Check Left
        if (numberStart - 1 >= 0) {
            if (isSymbol(lines[numberLine][numberStart - 1])) {
                return true;
            }
        }

        // Check Right
        if (numberStart + numberLength < lines[numberLine].length) {
            if (isSymbol(lines[numberLine][numberStart + numberLength])) {
                return true;
            }
        }

        return false;
    }

    private static boolean isNumber(char c) {
        return NUMBERS.contains(c);
    }

    private static boolean isSymbol(char c) {
        return !NOT_SYMBOL.contains(c);
    }

}
