package com.it.cinemabackend.auth.domain.dto.validator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import javax.validation.ConstraintValidatorContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;

class PasswordValidatorTest {

    PasswordValidator passwordValidator = new PasswordValidator();

    @Mock
    ConstraintValidatorContext constraintValidatorContext;

    @ParameterizedTest(name = "#{index} - Test password: \"{0}\"")
    @MethodSource("isValidSuccessData")
    void isValidSuccess(String pass) {
        assertTrue(passwordValidator.isValid(pass, constraintValidatorContext));
    }

    @ParameterizedTest(name = "#{index} - Test password: \"{0}\"")
    @MethodSource("isValidFailureData")
    void isValidFailure(String pass) {
        assertFalse(passwordValidator.isValid(pass, constraintValidatorContext));
    }

    public static Stream<String> isValidSuccessData() {
        return Stream.of(
            "1!Abcdefghij",
            "Jabad4baDu!23",
            "Czajnik123!@123",
            "123)PuscJaPo2221",
            "wiedzIalam1#",
            "PuscJa#321asasd"
        );
    }

    public static Stream<String> isValidFailureData() {
        return Stream.of(
            "",
            "123",
            "123456789101",
            "abcdefghijkl",
            "1Abcdefghijk",
            "!Aa45678901234567890a"
        );
    }
}
