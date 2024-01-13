package com.chrisdmilner.adventofcode.twentythree.day18;

import com.chrisdmilner.adventofcode.twentythree.common.Coordinates;
import com.chrisdmilner.adventofcode.twentythree.common.floodfill.FloodFill;

import java.util.List;
import java.util.Set;

public class TrenchVolumeFinder extends FloodFill<Coordinates> {
    private final Set<Coordinates> border;

    public TrenchVolumeFinder(Set<Coordinates> border) {
        this.border = border;
    }


    @Override
    protected boolean isBorder(Coordinates node) {
        return border.contains(node);
    }

    @Override
    protected List<Coordinates> getNeighbours(Coordinates node) {
        return node.getNeighboursIncludingDiagonal();
    }
}
