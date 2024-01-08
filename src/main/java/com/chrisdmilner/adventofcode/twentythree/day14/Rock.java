package com.chrisdmilner.adventofcode.twentythree.day14;

public enum Rock {
    ROUNDED, CUBE, NONE;

    public static Rock fromChar(char c) {
        return switch (c) {
            case 'O' -> ROUNDED;
            case '#' -> CUBE;
            case '.' -> NONE;
            default -> throw new RuntimeException("Invalid Rock char: " + c);
        };
    }
}
