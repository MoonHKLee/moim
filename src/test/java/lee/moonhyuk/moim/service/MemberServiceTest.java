package lee.moonhyuk.moim.service;

import lee.moonhyuk.moim.domain.Member;
import lee.moonhyuk.moim.domain.Sex;
import lee.moonhyuk.moim.ui.dto.SignUpRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Test
    void test() {
        //given
        SignUpRequest input = SignUpRequest.sponsor()
                .name("이문혁")
                .birthDate("1994-09-25")
                .memberId("moonhyuk.lee")
                .password("P@ssw0rd")
                .email("moonhyuk.lee@gmail.com")
                .organization("NEXTSTEP")
                .sex(Sex.MALE)
                .build();

        //when
        Member member = memberService.signUpParticipant(input);

        //then
        assertThat(member.getName().isSameName("이문혁")).isTrue();
    }
}
