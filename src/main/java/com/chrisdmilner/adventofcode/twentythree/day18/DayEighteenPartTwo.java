package com.chrisdmilner.adventofcode.twentythree.day18;

import com.chrisdmilner.adventofcode.twentythree.common.Direction;

public class DayEighteenPartTwo extends DayEighteen {
    @Override
    Instruction parseInstruction(String line) {
        String colourSection = line.split(" ")[2];

        int directionNumber = Character.getNumericValue(colourSection.charAt(7));
        int distance = Integer.parseInt(colourSection.substring(2, 7), 16);

        Direction direction = switch (directionNumber) {
            case 0 -> Direction.EAST;
            case 1 -> Direction.SOUTH;
            case 2 -> Direction.WEST;
            case 3 -> Direction.NORTH;
            default -> throw new RuntimeException("Invalid direction number " + directionNumber);
        };

        return new Instruction(direction, distance);
    }
}
