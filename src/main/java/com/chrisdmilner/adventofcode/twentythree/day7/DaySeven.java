package com.chrisdmilner.adventofcode.twentythree.day7;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;

import java.io.IOException;
import java.util.List;

public abstract class DaySeven {
    abstract long getSolution(List<Hand> hands);

    public long solution(PuzzleInput input) throws IOException {
        return getSolution(
                input.streamLines()
                        .map(Hand::fromString)
                        .toList()
        );
    }

    record Hand(String hand, int bid) {
        static Hand fromString(String string) {
            String[] parts = string.split(" ");

            return new Hand(parts[0], Integer.parseInt(parts[1]));
        }
    }
}
