package com.chrisdmilner.adventofcode.twentythree.day17;

import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;
import com.chrisdmilner.adventofcode.twentythree.common.dijkstras.DijkstrasSolver;

import java.io.IOException;
import java.util.List;

public abstract class DaySeventeen implements PuzzleSolution {
    abstract DijkstrasSolver<HeatLossMapSolver.Node> getSolver(List<List<Integer>> map);

    @Override
    public long solution(PuzzleInput input) throws IOException {
        List<List<Integer>> heatLossMap = input.parseCharGrid(i -> Character.getNumericValue((char) i));

        return getSolver(heatLossMap).getShortestPath();
    }
}
