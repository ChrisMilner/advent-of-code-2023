package com.chrisdmilner.adventofcode.twentythree.day17;

import com.chrisdmilner.adventofcode.twentythree.common.Coordinates;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;

import java.io.IOException;
import java.util.*;

public abstract class DaySeventeen implements PuzzleSolution {
    @Override
    public long solution(PuzzleInput input) throws IOException {
        CityMap map = new CityMap(input.parseCharGrid(i -> Character.getNumericValue((char) i)));

        return findShortestPath(Coordinates.of(0, 0), map.getDimensions().move(-1, -1), map);
    }

    private long findShortestPath(Coordinates start, Coordinates end, CityMap map) {
        CityMap.Node currentNode = CityMap.createStartNode(start);

        PriorityQueue<QueueNode> priorityQueue = new PriorityQueue<>();
        Map<CityMap.Node, Integer> bestDistance = new HashMap<>();
        Set<CityMap.Node> visited = new HashSet<>();

        bestDistance.put(currentNode, 0);

        while (!currentNode.coordinates().equals(end)) {
            visited.add(currentNode);

            List<CityMap.Node> unvisitedNeighbours = map.getNeighbours(currentNode).stream()
                    .filter(n -> !visited.contains(n))
                    .toList();

            for (CityMap.Node neighbour : unvisitedNeighbours) {
                int newDistance = bestDistance.get(currentNode) + map.getDistance(neighbour);

                if (!bestDistance.containsKey(neighbour) || newDistance < bestDistance.get(neighbour)) {
                    bestDistance.put(neighbour, newDistance);
                    priorityQueue.add(new QueueNode(neighbour, newDistance));
                }
            }

            currentNode = Objects.requireNonNull(priorityQueue.poll()).node();
        }

        return bestDistance.get(currentNode);
    }

    private record QueueNode(CityMap.Node node, int distance) implements Comparable<QueueNode> {
        @Override
        public int hashCode() {
            return Objects.hash(node);
        }

        @Override
        public int compareTo(QueueNode o) {
            return Integer.compare(distance, o.distance());
        }
    }
}
