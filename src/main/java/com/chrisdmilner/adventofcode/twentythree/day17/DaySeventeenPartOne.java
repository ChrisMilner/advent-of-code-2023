package com.chrisdmilner.adventofcode.twentythree.day17;

import com.chrisdmilner.adventofcode.twentythree.common.dijkstras.DijkstrasSolver;

import java.util.List;

public class DaySeventeenPartOne extends DaySeventeen {
    @Override
    DijkstrasSolver<HeatLossMapSolver.Node> getSolver(List<List<Integer>> map) {
        return new HeatLossMapSolver(map, 0, 3);
    }
}
