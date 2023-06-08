package lee.moonhyuk.moim.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;

import java.time.LocalDate;

@Entity
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
