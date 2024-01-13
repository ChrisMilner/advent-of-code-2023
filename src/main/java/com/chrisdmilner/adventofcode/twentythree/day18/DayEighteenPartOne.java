package com.chrisdmilner.adventofcode.twentythree.day18;

import com.chrisdmilner.adventofcode.twentythree.common.Direction;

public class DayEighteenPartOne extends DayEighteen {
    @Override
    Instruction parseInstruction(String line) {
        String[] parts = line.split(" ");

        return new Instruction(
                Direction.fromUDLRChar(parts[0].charAt(0)),
                Integer.parseInt(parts[1])
        );
    }
}
