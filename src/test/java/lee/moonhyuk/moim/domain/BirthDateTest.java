package lee.moonhyuk.moim.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class BirthDateTest {

    @ParameterizedTest
    @NullAndEmptySource
    void test_null_empty(String input) {
        //then
        assertThatCode(() -> new BirthDate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("birthDate must not be null or empty");
    }

    @ParameterizedTest
    @NullSource
    void test_null_empty_local_date(LocalDate input) {
        //then
        assertThatCode(() -> new BirthDate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("birthDate must not be null or empty");
    }
}
