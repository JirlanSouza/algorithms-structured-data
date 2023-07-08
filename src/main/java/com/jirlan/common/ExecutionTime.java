package com.jirlan.common;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Function;

public class ExecutionTime {
    public static <TI, TR> TR mettle(TI input, Function<TI, TR> f) {
        var start = Instant.now();
        var result = f.apply(input);
        System.out.println(Duration.between(start, Instant.now()));
        return result;
    }
}
