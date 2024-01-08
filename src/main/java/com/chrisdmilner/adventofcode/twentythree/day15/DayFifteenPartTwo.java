package com.chrisdmilner.adventofcode.twentythree.day15;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class DayFifteenPartTwo extends DayFifteen {
    @Override
    long getSolution(List<String> instructions) {
        Map<Integer, List<Lens>> boxMap = new HashMap<>();

        for (String instruction : instructions) {
            if (instruction.contains("=")) {
                handleAdd(instruction, boxMap);
            } else {
                handleRemove(instruction, boxMap);
            }
        }

        int totalFocusingPower = 0;

        for (Map.Entry<Integer, List<Lens>> entry : boxMap.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i ++) {
                totalFocusingPower += calculateFocusingPower(entry.getKey(), i, entry.getValue().get(i).focalLength());
            }
        }

        return totalFocusingPower;
    }

    private void handleAdd(String instruction, Map<Integer, List<Lens>> boxMap) {
        String[] parts = instruction.split("=");

        String label = parts[0];
        int focalLength = Integer.parseInt(parts[1]);
        int box = hash(label);

        Lens lens = new Lens(focalLength, label);

        if (!boxMap.containsKey(box)) {
            boxMap.put(box, new LinkedList<>(List.of(lens)));
            return;
        }

        List<Lens> lenses = boxMap.get(box);

        if (lenses.stream().anyMatch(l -> l.label.equals(label))) {
            int replaceIndex = IntStream.range(0, lenses.size())
                    .filter(i -> lenses.get(i).label().equals(label))
                    .findFirst()
                    .orElse(0);

            lenses.set(replaceIndex, lens);
        } else {
            lenses.add(lens);
        }
    }

    private void handleRemove(String instruction, Map<Integer, List<Lens>> boxMap) {
        String label = instruction.substring(0, instruction.length() - 1);
        int box = hash(label);

        if (!boxMap.containsKey(box)) {
            return;
        }

        List<Lens> lenses = boxMap.get(box);

        if (lenses.stream().anyMatch(l -> l.label.equals(label))) {
            int removeIndex = IntStream.range(0, lenses.size())
                    .filter(i -> lenses.get(i).label().equals(label))
                    .findFirst()
                    .orElse(0);

            lenses.remove(removeIndex);
        }
    }

    private int calculateFocusingPower(int boxNumber, int slotNumber, int focalLength) {
        return (1 + boxNumber) * (1 + slotNumber) * focalLength;
    }

    record Lens(int focalLength, String label) {};
}
