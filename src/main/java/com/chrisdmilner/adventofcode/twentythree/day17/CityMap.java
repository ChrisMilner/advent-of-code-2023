package com.chrisdmilner.adventofcode.twentythree.day17;

import com.chrisdmilner.adventofcode.twentythree.common.Coordinates;
import com.chrisdmilner.adventofcode.twentythree.common.Direction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CityMap {
    private static final int MAX_STRAIGHT_MOVES = 3;

    private final List<List<Integer>> heatLossGrid;

    public CityMap(List<List<Integer>> heatLossGrid) {
        this.heatLossGrid = heatLossGrid;
    }

    public static Node createStartNode(Coordinates start) {
        return new Node(start, Direction.NORTH, MAX_STRAIGHT_MOVES);
    }

    public List<Node> getNeighbours(Node node) {
        List<Node> neighbours = Arrays.stream(Direction.values())
                .filter(d -> !d.equals(node.direction()) && !d.equals(node.direction().opposite()))
                .filter(d -> Coordinates.isWithinBounds(node.coordinates().move(d), getDimensions()))
                .map(d -> new Node(node.coordinates().move(d), d, MAX_STRAIGHT_MOVES - 1))
                .collect(Collectors.toList());

        Coordinates straightMoveCoordinates = node.coordinates().move(node.direction());
        if (node.straightMoveRemaining() > 0 && Coordinates.isWithinBounds(straightMoveCoordinates, getDimensions())) {
            neighbours.add(new Node(
                    straightMoveCoordinates,
                    node.direction,
                    node.straightMoveRemaining() - 1));
        }

        return neighbours;
    }

    public int getDistance(Node node) {
        Coordinates coordinates = node.coordinates();

        return heatLossGrid.get(coordinates.y()).get(coordinates.x());
    }

    public Coordinates getDimensions() {
        return Coordinates.of(heatLossGrid.getFirst().size(), heatLossGrid.size());
    }

    public record Node(Coordinates coordinates, Direction direction, int straightMoveRemaining) {}
}
