package com.chrisdmilner.adventofcode.twentythree.common;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamUtils {
    public static <T> Stream<EnumeratedElement<T>> streamEnumeratedList(List<T> list) {
        return IntStream.range(0, list.size())
                .mapToObj(i -> new EnumeratedElement<>(i, list.get(i)));

    }

    public record EnumeratedElement<T>(int index, T value) {}
}
