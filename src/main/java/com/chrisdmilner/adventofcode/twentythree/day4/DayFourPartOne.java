package com.chrisdmilner.adventofcode.twentythree.day4;

import java.util.List;

public class DayFourPartOne extends DayFour {
    @Override
    int getSolution(List<Card> cards) {
        return cards.stream().mapToInt(this::calculatePoints).sum();
    }

    private int calculatePoints(Card card) {
        int points = 0;

        for (int ourNumber : card.ourNumbers()) {
            if (card.winningNumbers().contains(ourNumber)) {
                if (points == 0) {
                    points = 1;
                } else {
                    points *= 2;
                }
            }
        }

        return points;
    }
}
