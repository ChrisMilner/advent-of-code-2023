package com.chrisdmilner.adventofcode.twentythree.day12;

public enum Spring {
    OPERATIONAL, DAMAGED, UNKNOWN;

    public static Spring FromChar(int c) {
        return switch (c) {
            case '.' -> OPERATIONAL;
            case '#' -> DAMAGED;
            case '?' -> UNKNOWN;
            default -> throw new RuntimeException("Unrecognised spring char + " + c);
        };
    }

    public boolean isOperational() {
        return this == OPERATIONAL;
    }

    public boolean isKnown() {
        return this != UNKNOWN;
    }

    public boolean isDamaged() {
        return this == DAMAGED;
    }
}
