package com.chrisdmilner.adventofcode.twentythree.day16;

import com.chrisdmilner.adventofcode.twentythree.common.Coordinates;
import com.chrisdmilner.adventofcode.twentythree.common.Direction;

import java.util.List;

public class DaySixteenPartOne extends DaySixteen {
    private static final Leaf STARTING_POSITION = new Leaf(new Coordinates(-1, 0), Direction.EAST);

    @Override
    long solveProblem(List<List<Reflector>> grid) {
        return getNumberOfEnergisedTiles(grid, STARTING_POSITION);
    }
}
