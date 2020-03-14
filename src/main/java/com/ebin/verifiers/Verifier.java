package com.ebin.verifiers;

public interface Verifier<T>{
    boolean verify(VerifierContext verifierContext);

    boolean verify(T object, VerifierContext verifierContext);
}
