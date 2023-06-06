package lee.moonhyuk.moim.domain;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class BirthDate {
    private LocalDate birthDate;
}
