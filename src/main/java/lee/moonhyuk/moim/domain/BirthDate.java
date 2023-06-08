package lee.moonhyuk.moim.domain;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Embeddable
public class BirthDate {
    private LocalDate birthDate;

    public BirthDate() {
    }

    public BirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public BirthDate(String birthDate) {
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
