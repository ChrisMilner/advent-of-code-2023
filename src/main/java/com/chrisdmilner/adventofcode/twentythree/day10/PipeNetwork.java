package com.chrisdmilner.adventofcode.twentythree.day10;

import java.util.Arrays;
import java.util.List;

import static com.chrisdmilner.adventofcode.twentythree.day10.Direction.*;

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

        return new Coordinates(-1, -1);
    }

    public List<Direction> getPossibleMoves() {
        return getPipeAtCoordinate(currentLocation)
                .getPossibleDirections().stream()
                .filter(this::hasReceivingPipe)
                .toList();
    }

    private boolean hasReceivingPipe(Direction direction) {
        return switch (direction) {
            case NORTH -> getPipeAtCoordinate(currentLocation.x, currentLocation.y - 1).getPossibleDirections().contains(SOUTH);
            case EAST -> getPipeAtCoordinate(currentLocation.x + 1, currentLocation.y).getPossibleDirections().contains(WEST);
            case SOUTH -> getPipeAtCoordinate(currentLocation.x, currentLocation.y + 1).getPossibleDirections().contains(NORTH);
            case WEST -> getPipeAtCoordinate(currentLocation.x - 1, currentLocation.y).getPossibleDirections().contains(EAST);
        };
    }

    private Pipe getPipeAtCoordinate(int x, int y) {
        return network.get(y).get(x);
    }

    private Pipe getPipeAtCoordinate(Coordinates coordinates) {
        return getPipeAtCoordinate(coordinates.x, coordinates.y);
    }

    public void move(Direction direction) {
        System.out.println("Moving " + direction.toString());
        currentLocation = currentLocation.move(direction);
    }

    public boolean atStart() {
        return getPipeAtCoordinate(currentLocation).equals(Pipe.START);
    }

    record Coordinates(int x, int y) {
        public Coordinates move(Direction direction) {
            return switch (direction) {
                case NORTH -> new Coordinates(x, y - 1);
                case EAST -> new Coordinates(x + 1, y);
                case SOUTH -> new Coordinates(x, y + 1);
                case WEST -> new Coordinates(x - 1, y);
            };
        }
    }

    enum Pipe {
        NORTH_SOUTH('|', List.of(NORTH, SOUTH)),
        EAST_WEST('-', List.of(EAST, WEST)),
        NORTH_EAST('L', List.of(NORTH, EAST)),
        NORTH_WEST('J', List.of(NORTH, WEST)),
        SOUTH_WEST('7', List.of(SOUTH, WEST)),
        SOUTH_EAST('F', List.of(SOUTH, EAST)),
        GROUD('.', List.of()),
        START('S', List.of(NORTH, EAST, SOUTH, WEST));

        private final char charRepresentation;
        private final List<Direction> directions;

        Pipe(char charRepresentation, List<Direction> directions) {
            this.charRepresentation = charRepresentation;
            this.directions = directions;
        }

        static Pipe fromChar(char character) {
            return Arrays.stream(Pipe.values()).filter(e -> e.charRepresentation == character).findFirst().get();
        }

        public List<Direction> getPossibleDirections() {
            return directions;
        }
    }
}
