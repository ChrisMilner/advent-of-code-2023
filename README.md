# Advent of Code 2023

My attempts/solutions to the problem from Advent of Code 2023, written in Java.

> Still in progress as of `08/01/24`

## Structure

For every problem there is an abstract class e.g. `DayOne` with two implementation e.g. `DayOnePartOne`, `DayOnePartTwo`.
Common code between the parts is stored in the super class (generally parsing and some common functions).

For each Day there is a single test class, for example `DayOneTests` which tests each of the scenarios (including the example case if I found it necessary to use it).
