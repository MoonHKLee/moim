package lee.moonhyuk.moim.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    @Embedded
    private Name name;
    @Embedded
    private BirthDate birthDate;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Embedded
    private MemberId memberId;
    @Embedded
    private Password password;
    @Embedded
    private Email email;

    public Member() {}
    public Member(String memberId, String password) {
        this.memberId = new MemberId(memberId);
        this.password = new Password(password);
    }
    public Member(String name, LocalDate birthDate, Sex sex, String memberId, String password, String email) {
        this.name = new Name(name);
        this.birthDate = new BirthDate(birthDate);
        this.sex = sex;
        this.memberId = new MemberId(memberId);
        this.password = new Password(password);
        this.email = new Email(email);
    }
    public Member(Long seq, Name name, BirthDate birthDate, Sex sex, MemberId memberId, Password password, Email email) {
        this.seq = seq;
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
        this.memberId = memberId;
        this.password = password;
        this.email = email;
    }

    public Long getSeq() {
        return seq;
    }

    public String getMemberId() {
        return memberId.getMemberId();
    }
    public String getPassword() {
        return password.getPassword();
    }
}
