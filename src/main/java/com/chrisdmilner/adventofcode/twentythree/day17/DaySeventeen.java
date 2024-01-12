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
                }
            }

            currentNode = bestDistance.entrySet().stream()
                    .filter(e -> !visited.contains(e.getKey()))
                    .min(Map.Entry.comparingByValue())
                    .orElseThrow()
                    .getKey();
        }

        return bestDistance.get(currentNode);
    }
}
