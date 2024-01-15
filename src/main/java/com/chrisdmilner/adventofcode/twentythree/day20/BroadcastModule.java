package com.chrisdmilner.adventofcode.twentythree.day20;

import java.util.List;

public class BroadcastModule extends Module {
    protected BroadcastModule(List<String> destinations) {
        super(destinations);
    }

    @Override
    Pulse receive(String source, Pulse pulse) {
        return pulse;
    }
}
