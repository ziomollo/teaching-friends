package com.ebin.verifiers;

import com.ebin.TimeSupplier;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;


public class AgeVerifier implements Verifier<Instant> {

    private TimeSupplier timeSupplier;

    public AgeVerifier(TimeSupplier timeSupplier) {
        this.timeSupplier = timeSupplier;
    }

    @Override
    public boolean verify(VerifierContext verifierContext) {
        return false;
    }

    @Override
    public boolean verify(Instant instant, VerifierContext verifierContext) {
        if (verifierContext == null || instant == null) {
            return false;
        }
        Instant dateWhenMinimumAgeIsAchieved = instant.atZone(ZoneId.of("Poland")).plusYears(verifierContext.getMinimumAge()).toInstant();
        return timeSupplier.get().isAfter(dateWhenMinimumAgeIsAchieved);
    }
}
