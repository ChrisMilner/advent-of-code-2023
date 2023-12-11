package com.chrisdmilner.adventofcode.twentythree.day11;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;
import com.chrisdmilner.adventofcode.twentythree.common.Coordinates;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class DayEleven implements PuzzleSolution {
    abstract long findSumOfDistances(List<Coordinates> galaxyCoordinates);

    @Override
    public long solution(PuzzleInput input) throws IOException {
        return findSumOfDistances(parseGalaxyLocations(input.readLines()));
    }

    private List<Coordinates> parseGalaxyLocations(List<String> lines) {
        List<Coordinates> coordinates = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            List<Character> chars = lines.get(i).chars().mapToObj(c -> (char) c).toList();

            for (int j = 0; j < chars.size(); j++) {
                if (chars.get(j).equals('#')) {
                    coordinates.add(new Coordinates(j, i));
                }
            }
        }

        return coordinates;
    }
}
