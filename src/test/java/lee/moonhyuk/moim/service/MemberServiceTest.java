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
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setName("이문혁");
        signUpRequest.setBirthDate("1994-09-25");
        signUpRequest.setMemberId("moonhyuk.lee");
        signUpRequest.setPassword("P@ssw0rd");
        signUpRequest.setEmail("moonhyuk.lee@gmail.com");
        signUpRequest.setOrganization("NEXTSTEP");
        signUpRequest.setSex(Sex.MALE);

        //when
        Member member = memberService.signUpParticipant(signUpRequest);

        //then
        assertThat(member.getName().isSameName("이문혁")).isTrue();
    }
}
