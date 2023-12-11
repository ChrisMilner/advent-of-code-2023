package com.chrisdmilner.adventofcode.twentythree.day10;

import java.util.List;

public class PipeNetwork {
    private final List<List<Pipe>> network;
    private Coordinates currentLocation;

    private PipeNetwork(List<List<Pipe>> network, Coordinates coordinates) {
        this.network = network;
        this.currentLocation = coordinates;
    }

    public static PipeNetwork fromStrings(List<String> strings) {
        List<List<Pipe>> pipes = strings.stream()
                .map(string -> string.chars()
                        .mapToObj(c -> Pipe.fromChar((char) c))
                        .toList())
                .toList();

        return new PipeNetwork(pipes, findStartPosition(pipes));
    }

    private static Coordinates findStartPosition(List<List<Pipe>> pipes) {
        for (int i = 0; i < pipes.size(); i++) {
            for (int j = 0; j < pipes.get(i).size(); j++) {
                if (pipes.get(i).get(j) == Pipe.START) {
                    return new Coordinates(j, i);
                }
            }
        }

        throw new RuntimeException("No Start point found");
    }

    public List<Direction> getPossibleMoves() {
        return getPipeAtCoordinate(currentLocation).getPossibleDirections().stream()
                .filter(this::haveReceivingPipe)
                .toList();
    }

    public void move(Direction direction) {
        currentLocation = currentLocation.move(direction);
    }

    public boolean atStart() {
        return getPipeAtCoordinate(currentLocation).equals(Pipe.START);
    }

    private boolean haveReceivingPipe(Direction direction) {
        return getPipeAtCoordinate(currentLocation.move(direction))
                .getPossibleDirections().contains(direction.opposite());
    }

    private Pipe getPipeAtCoordinate(Coordinates coordinates) {
        return getPipeAtCoordinate(coordinates.x(), coordinates.y());
    }

    private Pipe getPipeAtCoordinate(int x, int y) {
        return network.get(y).get(x);
    }
}
