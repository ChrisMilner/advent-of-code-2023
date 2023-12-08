package com.chrisdmilner.adventofcode.twentythree.day7;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class DaySevenPartTwo extends DaySeven {
    @Override
    Comparator<Hand> getComparator() {
        return new HandComparator();
    }

    static class HandComparator implements Comparator<Hand> {
        @Override
        public int compare(Hand a, Hand b) {
            HandType aType = getHandType(a);
            HandType bType = getHandType(b);

            if (aType == bType) {
                char[] aChars = a.hand().toCharArray();
                char[] bChars = b.hand().toCharArray();
                int comparison = 0;

                for (int i = 0; i < aChars.length; i++) {
                    comparison = compareCardChars(aChars[i], bChars[i]);

                    if (comparison != 0) {
                        return comparison;
                    }
                }

                return comparison;
            }

            return HandType.compare(aType, bType);
        }

        private HandType getHandType(Hand hand) {
            Map<Character, Integer> charFrequency = stringToCharFrequency(hand.hand());

            replaceJokers(charFrequency);

            return getHandTypeFromCardFrequency(charFrequency);
        }

        private void replaceJokers(Map<Character, Integer> frequency) {
            List<Map.Entry<Character, Integer>> nonJokerEntries = frequency.entrySet().stream()
                    .filter(c -> !c.getKey().equals('J'))
                    .toList();

            if (nonJokerEntries.isEmpty()) {
                return;
            }

            char mostFrequentCard = Collections.max(nonJokerEntries, Map.Entry.comparingByValue()).getKey();

            frequency.put(mostFrequentCard, frequency.get(mostFrequentCard) + frequency.getOrDefault('J', 0));
            frequency.remove('J');
        }

        private int compareCardChars(char a, char b) {
            if (a == b) {
                return 0;
            }

            return Integer.compare(cardCharToRank(a), cardCharToRank(b));
        }

        private static int cardCharToRank(char c) {
            return switch (c) {
                case 'A' ->  14;
                case 'K' ->  13;
                case 'Q' ->  12;
                case 'T' ->  10;
                case '9' ->   9;
                case '8' ->   8;
                case '7' ->   7;
                case '6' ->   6;
                case '5' ->   5;
                case '4' ->   4;
                case '3' ->   3;
                case '2' ->   2;
                case 'J' ->   1;
                default  ->  -1;
            };
        }
    }
}
