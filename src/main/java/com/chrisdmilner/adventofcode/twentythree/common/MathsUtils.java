package com.chrisdmilner.adventofcode.twentythree.common;

import java.math.BigInteger;

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
}
