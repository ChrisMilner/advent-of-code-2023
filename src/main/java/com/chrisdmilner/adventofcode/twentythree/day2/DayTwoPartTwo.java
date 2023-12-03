package com.chrisdmilner.adventofcode.twentythree.day2;

import java.util.stream.Stream;

public class DayTwoPartTwo extends DayTwo {
    @Override
    int getSolution(Stream<Game> games) {
        return games
                .mapToInt(game -> game.maxRedsInSet() * game.maxGreensInSet() * game.maxBluesInSet())
                .sum();
    }
}
