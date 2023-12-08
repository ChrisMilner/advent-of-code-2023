package com.chrisdmilner.adventofcode.twentythree.day7;

import java.util.Comparator;
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
            // TODO: Update to account for Jokers
            Map<Character, Integer> charFrequency = stringToCharFrequency(hand.hand());

            if (charFrequency.size() == 1) {
                return HandType.FIVE_OF_A_KIND;
            }

            if (charFrequency.size() == 5) {
                return HandType.HIGH_CARD;
            }

            if (charFrequency.size() == 2) {
                if (charFrequency.values().stream().anyMatch(i -> i == 4)) {
                    return HandType.FOUR_OF_A_KIND;
                }

                return HandType.FULL_HOUSE;
            }

            if (charFrequency.values().stream().anyMatch(i -> i == 3)) {
                return HandType.THREE_OF_A_KIND;
            }

            if (charFrequency.values().stream().filter(i -> i == 2).count() == 2) {
                return HandType.TWO_PAIR;
            }

            return HandType.ONE_PAIR;
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
