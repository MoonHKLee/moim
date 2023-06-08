package lee.moonhyuk.moim.domain;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@SpringBootTest
@Transactional
@Sql("/truncate.sql")
public class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("참여자 생성")
    void test_참여자_생성() {
        //given
        Participant participant = new Participant("이문혁", LocalDate.now(), Sex.MALE, "moonhyuk", "1234", "moonhyuk.lee@gmail.com", null, "안녕하세요");

        //when
        Participant save = memberRepository.save(participant);

        //then
        assertThatCode(()->memberRepository.findById(save.getSeq())).doesNotThrowAnyException();
        assertThat(save.getSeq()).isEqualTo(1L);
    }

    @Test
    @DisplayName("주최자 생성")
    void test_주최자_생성() {
        //given
        Sponsor sponsor = new Sponsor("이문혁", LocalDate.now(), Sex.MALE, "moonhyuk", "1234", "moonhyuk.lee@gmail.com", "아무소속");

        //when
        Sponsor save = memberRepository.save(sponsor);

        //then
        assertThatCode(()->memberRepository.findById(save.getSeq())).doesNotThrowAnyException();
        assertThat(save.getSeq()).isEqualTo(1L);
    }
}
