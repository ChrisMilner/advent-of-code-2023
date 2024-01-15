package com.chrisdmilner.adventofcode.twentythree.day20;

import java.util.Arrays;
import java.util.List;

public abstract class Module {
    private final List<String> destinations;

    abstract Pulse receive(String source, Pulse pulse);

    protected Module(List<String> destinations) {
        this.destinations = destinations;
    }

    public static Module fromLine(String line) {
        List<String> destinations = Arrays.stream(line.split("-> ")[1].split(", ")).toList();

        if (line.startsWith("broadcast")) {
            return new BroadcastModule(destinations);
        }

        if (line.startsWith("%")) {
            return new FlipFlopModule(destinations);
        }

        return new ConjunctionModule(destinations);
    }

    public List<String> getDestinations() {
        return destinations;
    }
}
