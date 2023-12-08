package com.chrisdmilner.adventofcode.twentythree.day8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Network {
    private final Map<String, Fork> map;
    private List<String> currentLocations;

    private Network(Map<String, Fork> map) {
        this.map = map;
        this.currentLocations = List.of("AAA");
    }

    public List<String> getCurrentLocations() {
        return currentLocations;
    }

    public void setCurrentLocations(List<String> locations) {
        currentLocations = locations;
    }

    public void goLeft() {
        currentLocations = currentLocations.stream().map(l -> map.get(l).left()).toList();
    }

    public void goRight() {
        currentLocations = currentLocations.stream().map(l -> map.get(l).right()).toList();
    }

    public static Network fromLines(List<String> lines) {
        return new Network(
                lines.stream()
                        .map(l -> l.split(" = "))
                        .collect(Collectors.toMap(
                        l -> l[0],
                        l -> Fork.fromLine(l[1])
                ))
        );
    }

    record Fork(String left, String right) {
        static Fork fromLine(String line) {
            String[] parts = line.split(", ");

            return new Fork(parts[0].substring(1), parts[1].substring(0, parts[1].length() - 1));
        }
    }
}
