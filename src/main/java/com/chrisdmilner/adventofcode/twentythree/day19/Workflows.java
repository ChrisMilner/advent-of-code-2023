package com.chrisdmilner.adventofcode.twentythree.day19;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Workflows {
    private static final String ACCEPTED = "A";
    private static final String REJECTED = "R";

    private final Map<String, Workflow> workflowByName;

    public Workflows(Map<String, Workflow> workflowByName) {
        this.workflowByName = workflowByName;
    }

    public static Workflows fromLines(List<String> lines) {
        Map<String, Workflow> workflowByName = lines.stream()
                .map(line -> line.split("\\{"))
                .collect(Collectors.toMap(
                        parts -> parts[0],
                        parts -> Workflow.fromLine(parts[1].substring(0, parts[1].length() - 1))
                ));

        return new Workflows(workflowByName);
    }

    public boolean shouldAccept(DayNineteen.Part part) {
        Outcome outcome = workflowByName.get("in").applyTo(part);

        while (!outcome.done()) {
            outcome = workflowByName.get(outcome.nextWorkflow()).applyTo(part);
        }

        return outcome.accepted();
    }

    public List<Integer> getAllTransitionPoints(char c) {
        return workflowByName.values().stream()
                .flatMap(w -> w.streamTransitionPoints(c))
                .distinct()
                .sorted()
                .toList();
    }

    public record Workflow(List<Rule> rules) {
        public static Workflow fromLine(String line) {
            return new Workflow(Arrays.stream(line.split(",")).map(Rule::fromString).toList());
        }

        public Outcome applyTo(DayNineteen.Part part) {
            for (Rule rule : rules) {
                Outcome ruleOutcome = rule.apply(part);

                if (ruleOutcome != null) {
                    return ruleOutcome;
                }
            }

            throw new RuntimeException("Run out of rules");
        }

        public Stream<Integer> streamTransitionPoints(char c) {
            return Stream.concat(
                    Stream.of(1),
                    rules.stream()
                            .filter(rule -> rule.category() == c)
                            .map(Rule::getTransitionPoint)
                            .filter(i -> i != -1)
            );
        }

        public record Rule(char category, Condition condition, int threshold, Outcome outcome) {
            public static Rule fromString(String string) {
                if (!string.contains(":")) {
                    return new Rule(' ', Condition.ALWAYS_TRUE, 0, Outcome.fromString(string));
                }

                String[] parts = string.split(":");

                if (string.contains("<")) {
                    String[] subparts = parts[0].split("<");

                    return new Rule(subparts[0].charAt(0), Condition.LESS_THAN, Integer.parseInt(subparts[1]), Outcome.fromString(parts[1]));
                }

                if (string.contains(">")) {
                    String[] subparts = parts[0].split(">");

                    return new Rule(subparts[0].charAt(0), Condition.GREATER_THAN, Integer.parseInt(subparts[1]), Outcome.fromString(parts[1]));
                }

                throw new RuntimeException("Unrecognised rule: " + string);
            }

            public int getTransitionPoint() {
                return switch (condition) {
                    case ALWAYS_TRUE -> -1;
                    case LESS_THAN -> threshold;
                    case GREATER_THAN -> threshold + 1;
                };
            }

            public Outcome apply(DayNineteen.Part part) {
                return switch (condition) {
                    case ALWAYS_TRUE -> outcome;
                    case LESS_THAN -> part.getRatingFromChar(category) < threshold ? outcome : null;
                    case GREATER_THAN -> part.getRatingFromChar(category) > threshold ? outcome : null;
                };
            }

            enum Condition {
                ALWAYS_TRUE, LESS_THAN, GREATER_THAN
            }
        }
    }

    record Outcome(boolean done, boolean accepted, String nextWorkflow) {
        public static Outcome fromString(String string) {
            if (string.equals(ACCEPTED)) {
                return new Outcome(true, true, null);
            }

            if (string.equals(REJECTED)) {
                return new Outcome(true, false, null);
            }

            return new Outcome(false, false, string);
        }
    }
}
