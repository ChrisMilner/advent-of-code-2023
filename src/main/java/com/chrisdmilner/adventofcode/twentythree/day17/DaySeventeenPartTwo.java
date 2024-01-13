package com.chrisdmilner.adventofcode.twentythree.day17;

import com.chrisdmilner.adventofcode.twentythree.common.dijkstras.DijkstrasProblem;

import java.util.List;

public class DaySeventeenPartTwo extends DaySeventeen {
    @Override
    DijkstrasProblem<HeatLossProblem.Node> getProblem(List<List<Integer>> map) {
        return new HeatLossProblem(map, 4, 10);
    }
}
