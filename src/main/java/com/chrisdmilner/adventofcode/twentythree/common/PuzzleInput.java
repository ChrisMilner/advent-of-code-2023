package com.chrisdmilner.adventofcode.twentythree.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class PuzzleInput {
    private final Path path;

    public PuzzleInput(Path path) {
        this.path = path;
    }

    public Stream<String> streamLines() throws IOException {
        return readLines().stream();
    }

    public List<String> readLines() throws IOException {
        return Files.readAllLines(path);
    }
}
