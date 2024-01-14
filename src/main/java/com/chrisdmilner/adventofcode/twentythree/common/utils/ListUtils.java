package com.chrisdmilner.adventofcode.twentythree.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ListUtils {
    public static <T> List<List<T>> splitList(List<T> list, Function<T, Boolean> delimiterFunc) {
        List<T> buffer = new ArrayList<>();
        List<List<T>> parts = new ArrayList<>();

        for (T element : list) {
            if (delimiterFunc.apply(element)) {
                if (!buffer.isEmpty()) {
                    parts.add(buffer);
                }
                buffer = new ArrayList<>();
            } else {
                buffer.add(element);
            }
        }

        if (!buffer.isEmpty()) {
            parts.add(buffer);
        }

        return parts;
    }

    public static <T> List<Integer> getGroupSizes(List<T> list) {
        List<Integer> groups = new ArrayList<>();
        int currGroup = 1;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).equals(list.get(i))) {
                currGroup++;
            } else {
                groups.add(currGroup);
                currGroup = 1;
            }
        }

        groups.add(currGroup);

        return groups;
    }

    public static <T> List<T> safeSubstring(List<T> list, int start, int end) {
        if (start > end) {
            return List.of();
        }

        return list.subList(start, end);
    }

    public static <T> List<T> flattenWithInterleaving(List<List<T>> list, T delimiter) {
        List<T> flattened = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            flattened.addAll(list.get(i));

            if (i < list.size() - 1) {
                flattened.add(delimiter);
            }
        }

        return flattened;
    }

    public static <T> List<T> duplicateList(List<T> list, int number) {
        return duplicateList(list, number, List.of());
    }

    public static <T> List<T> duplicateList(List<T> list, int number, T delimiter) {
        return duplicateList(list, number, List.of(delimiter));
    }

    public static <T> List<T> duplicateList(List<T> list, int number, List<T> delimiter) {
        List<T> duplicatedList = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            duplicatedList.addAll(list);

            if (i != number - 1) {
                duplicatedList.addAll(delimiter);
            }
        }

        return duplicatedList;
    }
}
