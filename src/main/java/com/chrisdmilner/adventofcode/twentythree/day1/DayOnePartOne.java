package com.chrisdmilner.adventofcode.twentythree.day1;

public class DayOnePartOne extends DayOne {
    int[] getDigits(String string) {
        return string.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .toArray();
    }
}
