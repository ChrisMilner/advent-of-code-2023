package com.chrisdmilner.adventofcode.twentythree.day8;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Network {
    private final Map<String, Fork> map;
    private String currentLocation;

    private Network(Map<String, Fork> map) {
        this.map = map;
        this.currentLocation = null;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public Set<String> allLocation() {
        return map.keySet();
    }

    public void setCurrentLocation(String location) {
        currentLocation = location;
    }

    public void goLeft() {
        currentLocation = map.get(currentLocation).left();
    }

    public void goRight() {
        currentLocation = map.get(currentLocation).right();
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
