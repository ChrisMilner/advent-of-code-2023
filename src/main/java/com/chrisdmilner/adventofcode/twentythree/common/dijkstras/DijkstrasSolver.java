package com.chrisdmilner.adventofcode.twentythree.common.dijkstras;

import java.util.*;

public class DijkstrasSolver {
    public static <T> int getShortestPath(DijkstrasProblem<T> problem) {
        T currentNode = problem.getStartNode();

        PriorityQueue<QueueNode<T>> priorityQueue = new PriorityQueue<>();
        Map<T, Integer> bestDistance = new HashMap<>();
        Set<T> visited = new HashSet<>();

        bestDistance.put(currentNode, 0);

        while (!problem.isEndNode(currentNode)) {
            visited.add(currentNode);

            List<T> unvisitedNeighbours = problem.getNeighbours(currentNode).stream()
                    .filter(n -> !visited.contains(n))
                    .toList();

            for (T neighbour : unvisitedNeighbours) {
                int newDistance = bestDistance.get(currentNode) + problem.getDistance(currentNode, neighbour);

                if (!bestDistance.containsKey(neighbour) || newDistance < bestDistance.get(neighbour)) {
                    bestDistance.put(neighbour, newDistance);
                    priorityQueue.add(new QueueNode<>(neighbour, newDistance));
                }
            }

            currentNode = Objects.requireNonNull(priorityQueue.poll()).node();
        }

        return bestDistance.get(currentNode);
    }

    private record QueueNode<T>(T node, int distance) implements Comparable<QueueNode<T>> {
        @Override
        public int compareTo(QueueNode o) {
            return Integer.compare(distance, o.distance());
        }
    }
}
