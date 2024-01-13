package com.chrisdmilner.adventofcode.twentythree.day17;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;
import com.chrisdmilner.adventofcode.twentythree.common.dijkstras.DijkstrasProblem;
import com.chrisdmilner.adventofcode.twentythree.common.dijkstras.DijkstrasSolver;

import java.io.IOException;
import java.util.List;

public abstract class DaySeventeen implements PuzzleSolution {
    abstract DijkstrasProblem<HeatLossProblem.Node> getProblem(List<List<Integer>> map);

    @Override
    public long solution(PuzzleInput input) throws IOException {
        List<List<Integer>> heatLossMap = input.parseCharGrid(i -> Character.getNumericValue((char) i));

        return DijkstrasSolver.getShortestPath(getProblem(heatLossMap));
    }
}
