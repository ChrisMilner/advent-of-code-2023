package com.chrisdmilner.adventofcode.twentythree.day2;

import java.util.Collection;

record Game(int id, Collection<CubeQuantities> sets) {
    record CubeQuantities(int noOfReds, int noOfGreens, int noOfBlues) {}

    public int maxRedsInSet() {
        return sets.stream().mapToInt(CubeQuantities::noOfReds).max().orElse(0);
    }

    public int maxGreensInSet() {
        return sets.stream().mapToInt(CubeQuantities::noOfGreens).max().orElse(0);
    }

    public int maxBluesInSet() {
        return sets.stream().mapToInt(CubeQuantities::noOfBlues).max().orElse(0);
    }
}
