package com.ebin;

import java.time.Instant;
import java.util.function.Supplier;

public class TimeSupplier implements Supplier<Instant> {
    @Override
    public Instant get() {
        return Instant.now();
    }
}
