package lee.moonhyuk.moim.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Sponsor extends Member {
    @Embedded
    private Organization organization;

    public Sponsor(String name, LocalDate birthDate, Sex sex, String memberId, String password, String email, String organization) {
        super(name, birthDate, sex, memberId, password, email);
        this.organization = new Organization(organization);
    }

    public Sponsor() {
    }
}
