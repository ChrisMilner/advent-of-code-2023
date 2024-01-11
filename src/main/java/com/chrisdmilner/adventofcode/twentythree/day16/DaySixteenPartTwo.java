package com.chrisdmilner.adventofcode.twentythree.day16;

import com.chrisdmilner.adventofcode.twentythree.common.Coordinates;
import com.chrisdmilner.adventofcode.twentythree.common.Direction;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DaySixteenPartTwo extends DaySixteen {
    @Override
    long solveProblem(List<List<Reflector>> grid) {
        int xDim = grid.getFirst().size();
        int yDim = grid.size();

        List<Leaf> startingLeaves = Stream.concat(
                IntStream.range(0, xDim).boxed().flatMap(x -> Stream.of(
                        new Leaf(new Coordinates(x, -1), Direction.SOUTH),
                        new Leaf(new Coordinates(x, yDim), Direction.NORTH)
                )),
                IntStream.range(0, yDim).boxed().flatMap(y -> Stream.of(
                        new Leaf(new Coordinates(-1, y), Direction.EAST),
                        new Leaf(new Coordinates(xDim, y), Direction.WEST)
                ))
        ).toList();

        long maxEnergisedTiles = 0;

        for (Leaf startLeaf : startingLeaves) {
            long energisedTiles = getNumberOfEnergisedTiles(grid, startLeaf);

            if (energisedTiles > maxEnergisedTiles) {
                maxEnergisedTiles = energisedTiles;
            }
        }

        return maxEnergisedTiles;
    }
}
