package com.chrisdmilner.adventofcode.twentythree.common.dijkstras;

import java.util.*;

public abstract class DijkstrasSolver<T> {
    protected abstract T getStartNode();

    protected abstract boolean isEndNode(T node);

    protected abstract List<T> getNeighbours(T node);

    protected abstract int getDistance(T from, T to);

    public int getShortestPath() {
        T currentNode = getStartNode();

        PriorityQueue<QueueNode<T>> priorityQueue = new PriorityQueue<>();
        Map<T, Integer> bestDistance = new HashMap<>();
        Set<T> visited = new HashSet<>();

        bestDistance.put(currentNode, 0);

        while (!isEndNode(currentNode)) {
            visited.add(currentNode);

            List<T> unvisitedNeighbours = getNeighbours(currentNode).stream()
                    .filter(n -> !visited.contains(n))
                    .toList();

            for (T neighbour : unvisitedNeighbours) {
                int newDistance = bestDistance.get(currentNode) + getDistance(currentNode, neighbour);

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
