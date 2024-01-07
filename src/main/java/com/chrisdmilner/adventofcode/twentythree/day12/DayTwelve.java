package com.chrisdmilner.adventofcode.twentythree.day12;

import com.chrisdmilner.adventofcode.twentythree.common.ListUtils;
import com.chrisdmilner.adventofcode.twentythree.common.MathsUtils;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DayTwelve implements PuzzleSolution {
    abstract List<Spring> adjustSprings(List<Spring> springs);
    abstract List<Integer> adjustGroups(List<Integer> groups);

    @Override
    public long solution(PuzzleInput input) throws IOException {
        return input.streamLines()
                .mapToLong(this::getSolutionForLine)
                .sum();
    }

    private long getSolutionForLine(String line) {
        String[] parts = line.split(" ");
        List<Spring> springs = adjustSprings(parseSprings(parts[0]));
        List<Integer> groups = adjustGroups(parseGroups(parts[1]));

        long numberOfPermutations = getNumberOfPermutations(springs, groups);

        System.out.println(springs);
        System.out.println(groups);
        System.out.println("ANSWER: " + numberOfPermutations);
        System.out.println();

        return numberOfPermutations;
    }

    private List<Spring> parseSprings(String line) {
        return line.chars().mapToObj(Spring::FromChar).toList();
    }

    private List<Integer> parseGroups(String line) {
        return Arrays.stream(line.split(",")).map(Integer::parseInt).toList();
    }

    private long getNumberOfPermutations(List<Spring> springs, List<Integer> groups) {
        int spaceRequiredForGroups = getSpaceRequiredForGroups(groups);

        if (spaceRequiredForGroups > springs.size()) {
            return 0;
        }

        if (springs.isEmpty()) {
            return 1;
        }

        if (springs.stream().anyMatch(Spring::isOperational)) {
            return handleRowWithOperational(springs, groups);
        }

        if (springs.getFirst().isKnown() || springs.getLast().isKnown()) {
            return handleRowRequiringTrimming(springs, groups);
        }

        // At that this point we must have a sequence of only KNOWN and DAMAGED beginning and ending with UNKNOWN
        return getPermutationsForTrimmedSection(ListUtils.getGroupSizes(springs), groups);
    }

    private long handleRowRequiringTrimming(List<Spring> springs, List<Integer> groups) {
        if (springs.stream().anyMatch(Spring::isOperational)) {
            throw new RuntimeException("Operational Springs found when trying to trim");
        }

        if (groups.isEmpty()) {
            return 0;
        }

        int springsTrimStart = 0;
        int groupsTrimStart = 0;

        while (springsTrimStart < springs.size() && springs.get(springsTrimStart).isDamaged()) {
            if (groupsTrimStart >= groups.size()) {
                return 0;
            }

            springsTrimStart += groups.get(groupsTrimStart) + 1;

            int bufferIndex = springsTrimStart - 1;
            if (bufferIndex < springs.size() && springs.get(bufferIndex).isDamaged()) {
                // The buffer is damaged, the group doesn't fit
                return 0;
            }

            groupsTrimStart++;
        }

        if (springsTrimStart > springs.size() + 1) {
            return 0;
        }

        int springsTrimEnd = springs.size() - 1;
        int groupsTrimEnd = groups.size() - 1;

        while (springsTrimEnd >= 0 && springsTrimEnd + 1 >= springsTrimStart && springs.get(springsTrimEnd).isDamaged()) {
            if (groupsTrimEnd < groupsTrimStart) {
                return 0;
            }

            springsTrimEnd -= groups.get(groupsTrimEnd) + 1;

            int bufferIndex = springsTrimEnd + 1;
            if (bufferIndex >= 0 && springs.get(bufferIndex).isDamaged()) {
                // The buffer is damaged, the group doesn't fit
                return 0;
            }

            groupsTrimEnd--;
        }

        if (springsTrimEnd < -2) {
            return 0;
        }

        return getNumberOfPermutations(
                ListUtils.safeSubstring(springs, springsTrimStart, springsTrimEnd + 1),
                ListUtils.safeSubstring(groups, groupsTrimStart, groupsTrimEnd + 1));
    }

    private long handleRowWithOperational(List<Spring> springs, List<Integer> groups) {
        List<List<Spring>> sections = ListUtils.splitList(springs, Spring::isOperational);

        if (sections.isEmpty()) {
            if (groups.isEmpty()) {
                return 1;
            }

            return 0;
        }

        long permutations = 0;

        for (int i = 0; i <= groups.size(); i++) {
            long firstSectionPermutations = getNumberOfPermutations(sections.getFirst(), groups.subList(0, i));

            if (firstSectionPermutations == 0) {
                continue;
            }

            long otherSectionsPermutations = getNumberOfPermutations(
                    ListUtils.flattenWithInterleaving(sections.subList(1, sections.size()), Spring.OPERATIONAL),
                    groups.subList(i, groups.size())
            );

            permutations += firstSectionPermutations * otherSectionsPermutations;
        }

        return permutations;
    }

    private long getPermutationsForTrimmedSection(List<Integer> section, List<Integer> groups) {
        if (section.isEmpty() && groups.isEmpty()) {
            return 1;
        }

        if (section.size() % 2 == 0) {
            if (groups.isEmpty()) {
                return 0;
            }

            try {
                return getPermutationsForTrimmedSection(removeGroupFromLeft(section, groups.getFirst()), groups.subList(1, groups.size()));
            } catch (DoesNotFitException e) {
                return 0;
            }
        }

        if (section.size() == 1) {
            return getPermutationsForAllUnknowns(section.getFirst(), groups);
        }

        int firstUnknowns = section.getFirst();
        int firstDamageds = section.get(1);

        long permutations = 0;

        for (int i = 0; i < groups.size(); i++) {
            if (firstDamageds > groups.get(i)) {
                // The actual group is larger than the one we're trying to fit
                continue;
            }

            for (int j = 0; j <= groups.get(i) - firstDamageds && firstUnknowns >= j; j++) {
                int leftUnknowns  = firstUnknowns - j - 1;
                List<Integer> leftGroups = groups.subList(0, i);

                List<Integer> rightSections;

                try {
                    rightSections = removeGroupFromLeft(section.subList(2, section.size()), groups.get(i) - section.get(1) - j);
                } catch (DoesNotFitException e) {
                    continue;
                }

                List<Integer> rightGroups = groups.subList(i + 1, groups.size());

                long leftPermutations = getPermutationsForAllUnknowns(leftUnknowns, leftGroups);

                if (leftPermutations == 0) {
                    continue;
                }

                long rightPermutations = getPermutationsForTrimmedSection(rightSections, rightGroups);

                permutations += leftPermutations * rightPermutations;
            }
        }

        return permutations;
    }

    private long getPermutationsForAllUnknowns(int unknowns, List<Integer> groups) {
        int minRequiredForGroups = getSpaceRequiredForGroups(groups);

        if (minRequiredForGroups > unknowns) {
            return 0;
        }

        if (minRequiredForGroups == unknowns) {
            return 1;
        }

        return MathsUtils.barsAndStars(groups.size(), unknowns - minRequiredForGroups);
    }

    private List<Integer> removeGroupFromLeft(List<Integer> list, int n) {
        int toRemove = n;

        for (int i = 0; i < list.size(); i++) {
            if (toRemove < list.get(i)) {
                if ((list.size() - i) % 2 == 0) {
                    // There is a damaged spring where the buffer needs to be
                    throw new DoesNotFitException();
                }

                List<Integer> result = new ArrayList<>();

                if (list.get(i) > toRemove + 1) {
                    result.add(list.get(i) - (toRemove + 1));
                }

                result.addAll(list.subList(i + 1, list.size()));

                return result;
            }

            toRemove -= list.get(i);
        }

        // If we've got nothing more to remove, or only the buffer to remove, return empty
        if (toRemove == 0) {
            return List.of();
        }

        throw new DoesNotFitException();
    }

    private int getSpaceRequiredForGroups(List<Integer> groups) {
        return groups.stream().mapToInt(i -> i).sum() + groups.size() - 1;
    }

    private static class DoesNotFitException extends RuntimeException {}
}
