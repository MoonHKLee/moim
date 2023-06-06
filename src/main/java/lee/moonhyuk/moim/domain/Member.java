package lee.moonhyuk.moim.domain;

import jakarta.persistence.*;

@Entity
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
}
