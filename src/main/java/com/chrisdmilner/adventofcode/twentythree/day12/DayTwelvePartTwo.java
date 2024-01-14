package com.chrisdmilner.adventofcode.twentythree.day12;

import com.chrisdmilner.adventofcode.twentythree.common.utils.ListUtils;

import java.util.List;

public class DayTwelvePartTwo extends DayTwelve {
    @Override
    List<Spring> adjustSprings(List<Spring> springs) {
        return ListUtils.duplicateList(springs, 5, Spring.UNKNOWN);
    }

    @Override
    List<Integer> adjustGroups(List<Integer> groups) {
        return ListUtils.duplicateList(groups, 5);
    }
}
