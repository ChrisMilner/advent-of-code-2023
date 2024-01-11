package com.chrisdmilner.adventofcode.twentythree.day16;

import com.chrisdmilner.adventofcode.twentythree.common.Coordinates;
import com.chrisdmilner.adventofcode.twentythree.common.Direction;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DaySixteen implements PuzzleSolution {
    abstract long solveProblem(List<List<Reflector>> grid);

    @Override
    public long solution(PuzzleInput input) throws IOException {
        return solveProblem(input.parseCharGrid(c -> Reflector.fromChar((char) c)));
    }

    long getNumberOfEnergisedTiles(List<List<Reflector>> grid, Leaf startingLeaf) {
        Map<Coordinates, List<Direction>> visited = new HashMap<>();

        List<Leaf> leaves = new ArrayList<>();
        leaves.add(startingLeaf);

        while (!leaves.isEmpty()) {
            List<Leaf> newLeaves = new ArrayList<>();

            for (Leaf leaf : leaves) {
                List<Leaf> proposedLeaves = followLeaf(grid, leaf).stream()
                        .filter(l -> !hasBeenVisited(l, visited))
                        .toList();

                proposedLeaves.forEach(l -> addVisited(visited, l));

                newLeaves.addAll(proposedLeaves);
            }

            leaves = newLeaves;
        }

        return visited.size();
    }

    private List<Leaf> followLeaf(List<List<Reflector>> grid, Leaf leaf) {
        Coordinates newPos = leaf.coordinates().move(leaf.direction());

        if (!inGridBounds(newPos, grid)) {
            return List.of();
        }

        List<Direction> newDirections = getReflector(grid, newPos).getResultingDirections(leaf.direction());

        return newDirections.stream().map(d -> new Leaf(newPos, d)).toList();
    }

    private boolean hasBeenVisited(Leaf leaf, Map<Coordinates, List<Direction>> visited) {
        if (!visited.containsKey(leaf.coordinates())) {
            return false;
        }

        return visited.get(leaf.coordinates()).contains(leaf.direction());
    }

    private boolean inGridBounds(Coordinates pos, List<List<Reflector>> grid) {
        boolean xInBounds = pos.x() >= 0 && pos.x() < grid.getFirst().size();
        boolean yInBounds = pos.y() >= 0 && pos.y() < grid.size();

        return xInBounds && yInBounds;
    }

    private Reflector getReflector(List<List<Reflector>> grid, Coordinates coordinates) {
        return grid.get(coordinates.y()).get(coordinates.x());
    }

    private void addVisited(Map<Coordinates, List<Direction>> visited, Leaf leaf) {
        List<Direction> directions = visited.getOrDefault(leaf.coordinates(), new ArrayList<>());
        directions.add(leaf.direction());

        visited.put(leaf.coordinates(), directions);
    }

    record Leaf(Coordinates coordinates, Direction direction) {}
}
