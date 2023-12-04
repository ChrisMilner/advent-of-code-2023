package com.chrisdmilner.adventofcode.twentythree.day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayFourPartTwo extends DayFour {
    @Override
    int getSolution(List<Card> cards) {
        List<Integer> scorePerCard = cards.stream().map(this::calculateScore).toList();
        List<Integer> quantityPerCard = new ArrayList<>(Collections.nCopies(cards.size(), 1));

        for (int i = 0; i < scorePerCard.size(); i++) {
            for (int j = 1; j <= scorePerCard.get(i); j++) {
                quantityPerCard.set(i + j, quantityPerCard.get(i + j) + quantityPerCard.get(i));
            }
        }

        return quantityPerCard.stream().mapToInt(x -> x).sum();
    }

    private int calculateScore(Card card) {
        return (int) card.ourNumbers().stream()
                .filter(n -> card.winningNumbers().contains(n))
                .count();
    }
}
