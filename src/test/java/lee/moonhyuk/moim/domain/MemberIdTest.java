package lee.moonhyuk.moim.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class MemberIdTest {

    @ParameterizedTest
    @NullAndEmptySource
    void test_null_empty(String input) {
        //then
        assertThatCode(() -> new MemberId(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("memberId must not be null or empty");
    }

    @Test
    void test_over3_length() {
        //then
        assertThatCode(() -> new MemberId("123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("memberId must be longer than 4");
    }
}
