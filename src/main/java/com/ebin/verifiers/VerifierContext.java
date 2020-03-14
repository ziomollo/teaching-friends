package com.ebin.verifiers;

public class VerifierContext {
    private Integer minimumAge;

    public VerifierContext(Integer minimumAge) {
        this.minimumAge = minimumAge;
    }

    public Integer getMinimumAge() {
        return minimumAge;
    }
}
