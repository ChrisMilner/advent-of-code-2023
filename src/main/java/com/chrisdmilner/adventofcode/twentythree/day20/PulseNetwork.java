package com.chrisdmilner.adventofcode.twentythree.day20;

import com.chrisdmilner.adventofcode.twentythree.common.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class PulseNetwork {
    private final Map<String, Module> moduleByName;

    public PulseNetwork(Map<String, Module> moduleByName) {
        this.moduleByName = moduleByName;
    }

    public static PulseNetwork fromLines(List<String> lines) {
        Map<String, Module> moduleByName = lines.stream()
                .collect(Collectors.toMap(PulseNetwork::parseModuleName, Module::fromLine));

        moduleByName.entrySet().stream()
                .filter(e -> e.getValue() instanceof ConjunctionModule)
                .forEach(e -> ((ConjunctionModule) e.getValue()).setInputs(getInputsForModule(moduleByName, e.getKey())));

        return new PulseNetwork(moduleByName);
    }

    private static List<String> getInputsForModule(Map<String, Module> moduleByName, String module) {
        return moduleByName.entrySet().stream()
                .filter(e -> e.getValue().getDestinations().contains(module))
                .map(Map.Entry::getKey)
                .toList();
    }

    private static String parseModuleName(String string) {
        String nameSection = string.split(" ->")[0];

        if (nameSection.startsWith("%") || nameSection.startsWith("&")) {
            return nameSection.substring(1);
        }

        return nameSection;
    }

    public Pair<Integer, Integer> start(BiConsumer<String, Pulse> monitor) {
        List<Step> steps = new ArrayList<>();
        steps.add(new Step(null, "broadcaster", Pulse.LOW));

        int lowPulses = 1;
        int highPulses = 0;

        while (!steps.isEmpty()) {
            List<Step> newSteps = new ArrayList<>();

            for (Step step : steps) {
                monitor.accept(step.destination(), step.pulse());

                if (!moduleByName.containsKey(step.destination())) {
                    continue;
                }

                Pulse result = moduleByName.get(step.destination()).receive(step.source(), step.pulse());

                if (result != Pulse.NONE) {
                    for (String newDestination : moduleByName.get(step.destination()).getDestinations()) {
                        newSteps.add(new Step(step.destination(), newDestination, result));

                        if (result == Pulse.HIGH) {
                            highPulses++;
                        } else {
                            lowPulses++;
                        }
                    }
                }
            }

            steps = newSteps;
        }

        return new Pair<>(lowPulses, highPulses);
    }

    public Pair<Integer, Integer> start() {
        return start((a, b) -> {});
    }

    record Step(String source, String destination, Pulse pulse) {}
}
