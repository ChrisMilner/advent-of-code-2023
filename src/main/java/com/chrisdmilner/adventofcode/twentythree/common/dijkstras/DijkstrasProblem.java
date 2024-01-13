package com.chrisdmilner.adventofcode.twentythree.common.dijkstras;

import java.util.List;

public interface DijkstrasProblem<T> {
    T getStartNode();

    boolean isEndNode(T node);

    List<T> getNeighbours(T node);

    int getDistance(T from, T to);
}
