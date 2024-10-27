package com.chrisdmilner.adventofcode.twentythree.common.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MathsUtils {
    public static long barsAndStars(int bars, int stars) {
        return factorial(bars + stars)
                .divide(factorial(bars).multiply(factorial(stars)))
                .longValue();
    }

    public static BigInteger factorial(long number) {
        BigInteger result = BigInteger.valueOf(1);

        for (long factor = 2; factor <= number; factor++) {
            result = result.multiply(BigInteger.valueOf(factor));
        }

        return result;
    }

    public static List<Integer> powersOfTwoUpTo(int n) {
        List<Integer> powersOfTwo = new ArrayList<>();

        int nextPower = 1;

        while (nextPower < n) {
            powersOfTwo.add(nextPower);

            nextPower = nextPower << 1;
        }

        return powersOfTwo;
    }

    public static long lowestCommonMultiple(List<Integer> nums) {
        long lcm = lowestCommonMultiple(nums.getFirst(), nums.get(1));

        for (int i = 2; i < nums.size(); i++) {
            lcm = lowestCommonMultiple(lcm, nums.get(i));
        }

        return lcm;
    }

    public static long lowestCommonMultiple(long a, long b) {
        long num = Math.max(a, b);
        long denominator = Math.min(a, b);

        long remainder = num % denominator;

        while (remainder != 0) {
            num = denominator;
            denominator = remainder;
            remainder = num % denominator;
        }

        return (a * b) / denominator;
    }
}
