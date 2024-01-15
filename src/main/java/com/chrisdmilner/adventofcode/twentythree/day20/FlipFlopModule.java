package com.chrisdmilner.adventofcode.twentythree.day20;

import java.util.List;

public class FlipFlopModule extends Module {
    private boolean on;

    protected FlipFlopModule(List<String> destinations) {
        super(destinations);

        this.on = false;
    }

    @Override
    Pulse receive(String source, Pulse pulse) {
        if (pulse == Pulse.HIGH) {
            return Pulse.NONE;
        }

        on = !on;

        return on ? Pulse.HIGH : Pulse.LOW;
    }
}
