package lee.moonhyuk.moim.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class PasswordTest {
    @Test
    void test_비밀번호_정상() {
        //then
        assertThatCode(()->new Password("Ansgur1234!@#$"))
                .doesNotThrowAnyException();
    }
}
