package com.chrisdmilner.adventofcode.twentythree.day19;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public record Workflow(List<Rule> rules) {
        public static Workflow fromLine(String line) {
            return new Workflow(Arrays.stream(line.split(",")).map(Rule::fromString).toList());
        }

        public Outcome applyTo(DayNineteen.Part part) {
            for (Rule rule : rules) {
                Outcome ruleOutcome = rule.condition().apply(part);

                if (ruleOutcome != null) {
                    return ruleOutcome;
                }
            }

            throw new RuntimeException("Run out of rules");
        }

        public record Rule(Function<DayNineteen.Part, Outcome> condition) {
            public static Rule fromString(String string) {
                if (string.contains(":")) {
                    return new Rule(getConditionFromString(string));
                }

                return new Rule(part -> Outcome.fromString(string));
            }

            private static Function<DayNineteen.Part, Outcome> getConditionFromString(String string) {
                String[] parts = string.split(":");

                if (parts[0].contains("<")) {
                    return part -> {
                        boolean passes = part.getRatingFromChar(parts[0].charAt(0)) < Integer.parseInt(parts[0].substring(2));

                        return passes ? Outcome.fromString(parts[1]) : null;
                    };
                }

                if (parts[0].contains(">")) {
                    return part -> {
                        boolean passes = part.getRatingFromChar(parts[0].charAt(0)) > Integer.parseInt(parts[0].substring(2));

                        return passes ? Outcome.fromString(parts[1]) : null;
                    };
                }

                throw new RuntimeException("Rule is missing a valid condition: " + string);
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
