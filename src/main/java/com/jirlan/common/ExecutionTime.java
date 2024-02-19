package com.jirlan.common;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Function;

public class ExecutionTime {
    public static <TI, TR> TR mettle(String name, TI input, Function<TI, TR> f) {
        var start = Instant.now();
        var result = f.apply(input);
        Duration duration = Duration.between(start, Instant.now());

        System.out.printf("%-16s: %s\n", name, formatterDuration(duration));
        return result;
    }

    private static String formatterDuration(Duration duration) {
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();
        long millis = duration.toMillisPart();

        StringBuilder builder = new StringBuilder();

        if (minutes > 0) {
            builder.append(minutes);
            builder.append("m ");
        }

        if (seconds > 0) {
            builder.append(seconds);
            builder.append("s ");
        }

        builder.append(millis);
        builder.append(" ms");

        return builder.toString();

    }
}
