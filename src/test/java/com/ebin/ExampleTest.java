package com.ebin;

import com.ebin.verifiers.AgeVerifier;
import com.ebin.verifiers.VerifierContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.BDDMockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ExampleTest {

    private TimeSupplier timeSupplier = mock(TimeSupplier.class);

    private AgeVerifier ageVerifier;

    @BeforeEach
    void setUp() {
        given(timeSupplier.get()).willReturn(Instant.now());
        ageVerifier = new AgeVerifier(timeSupplier);
    }

    @Test
    void addition() {
        //given
        int a = 5;
        int b = 4;

        //when
        int c = a + b;

        //then
        assertEquals(9, c);
    }


    @DisplayName("Should verify age if minimum age requirement is met")
    @ParameterizedTest
    @CsvSource({
            "1997-09-20T07:00:00.000Z, 2020-09-20T07:00:00.000Z, 21, true",
            "2000-09-20T07:00:00.000Z, 2020-09-20T07:00:00.000Z, 21, false"})
    void verifyTheAge(String dateOfBirth, String currentDate, Integer minimumAge, boolean expectedResult) {
        //given
        VerifierContext verifierContext = new VerifierContext(minimumAge);
        given(timeSupplier.get()).willReturn(Instant.parse(currentDate));

        //when
        boolean result = ageVerifier.verify(Instant.parse(dateOfBirth), verifierContext);

        //then
        assertEquals(expectedResult, result);
    }


}
