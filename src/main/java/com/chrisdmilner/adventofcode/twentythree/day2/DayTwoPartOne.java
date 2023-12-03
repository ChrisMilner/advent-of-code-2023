package com.chrisdmilner.adventofcode.twentythree.day2;

import java.util.stream.Stream;

public class DayTwoPartOne extends DayTwo {
    private static final int REDS = 12;
    private static final int GREENS = 13;
    private static final int BLUES = 14;

    @Override
    int getSolution(Stream<Game> games) {
        return games
                .filter(game -> game.maxRedsInSet() <= REDS && game.maxGreensInSet() <= GREENS && game.maxBluesInSet() <= BLUES)
                .mapToInt(Game::id)
                .sum();
    }
}
