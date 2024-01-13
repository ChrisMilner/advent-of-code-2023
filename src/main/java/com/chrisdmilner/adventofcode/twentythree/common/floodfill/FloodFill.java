package com.chrisdmilner.adventofcode.twentythree.common.floodfill;

import java.util.*;

public abstract class FloodFill<T> {
    protected abstract boolean isBorder(T node);

    protected abstract List<T> getNeighbours(T node);

    public int countInside(T start) {
        Set<T> inside = new HashSet<>();
        Queue<T> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            T current = queue.poll();

            if (inside.contains(current) || isBorder(current)) {
                continue;
            }

            inside.add(current);

            List<T> newNeighbours = getNeighbours(current).stream()
                    .filter(n -> !inside.contains(n))
                    .toList();

            queue.addAll(newNeighbours);
        }

        return inside.size();
    }
}
