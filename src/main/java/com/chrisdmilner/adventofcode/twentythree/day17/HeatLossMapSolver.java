package com.chrisdmilner.adventofcode.twentythree.day17;

import com.chrisdmilner.adventofcode.twentythree.common.Coordinates;
import com.chrisdmilner.adventofcode.twentythree.common.Direction;
import com.chrisdmilner.adventofcode.twentythree.common.dijkstras.DijkstrasSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeatLossMapSolver extends DijkstrasSolver<HeatLossMapSolver.Node> {
    private final List<List<Integer>> heatLossMap;
    private final int minStraightMoves;
    private final int maxStraightMoves;

    public HeatLossMapSolver(List<List<Integer>> heatLossMap, int minStraightMoves, int maxStraightMoves) {
        this.heatLossMap = heatLossMap;
        this.minStraightMoves = minStraightMoves;
        this.maxStraightMoves = maxStraightMoves;
    }

    @Override
    protected Node getStartNode() {
        return new Node(Coordinates.of(0, 0), Direction.EAST, 0);
    }

    @Override
    protected boolean isEndNode(Node node) {
        return node.coordinates().equals(getMapDimensions().move(-1, -1));
    }

    @Override
    protected List<Node> getNeighbours(Node node) {
        return getAllowedMoves(node).stream()
                .filter(n -> Coordinates.isWithinBounds(n.coordinates(), getMapDimensions()))
                .toList();
    }

    @Override
    protected int getDistance(Node from, Node to) {
        return heatLossMap.get(to.coordinates().y()).get(to.coordinates().x());
    }

    private List<Node> getAllowedMoves(Node node) {
        Node continueStraight = new Node(
                node.coordinates().move(node.direction()),
                node.direction(),
                node.straightMoves() + 1
        );

        if (node.straightMoves() < minStraightMoves) {
            return List.of(continueStraight);
        }

        List<Node> turn = Arrays.stream(Direction.values())
                .filter(d -> !d.equals(node.direction()) && !d.equals(node.direction().opposite()))
                .map(d -> new Node(node.coordinates().move(d), d, 1))
                .toList();

        if (node.straightMoves >= maxStraightMoves) {
            return turn;
        }

        List<Node> straightOrTurn = new ArrayList<>(turn);
        straightOrTurn.add(continueStraight);

        return straightOrTurn;
    }

    private Coordinates getMapDimensions() {
        return Coordinates.of(heatLossMap.getFirst().size(), heatLossMap.size());
    }

    public record Node(Coordinates coordinates, Direction direction, int straightMoves) {}
}
