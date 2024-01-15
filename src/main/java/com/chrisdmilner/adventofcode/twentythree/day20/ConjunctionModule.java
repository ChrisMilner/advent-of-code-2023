package com.chrisdmilner.adventofcode.twentythree.day20;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConjunctionModule extends Module {
    private Map<String, Boolean> lastPulse;

    protected ConjunctionModule(List<String> destinations) {
        super(destinations);

        this.lastPulse = new HashMap<>();
    }

    @Override
    Pulse receive(String source, Pulse pulse) {
        lastPulse.put(source, !lastPulse.get(source));

        return lastPulse.values().stream().allMatch(b -> b) ? Pulse.LOW : Pulse.HIGH;
    }

    void setInputs(List<String> inputs) {
        lastPulse = inputs.stream().collect(Collectors.toMap(i -> i, i -> false));
    }
}
