package lee.moonhyuk.moim.domain;

import javax.persistence.Embeddable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Embeddable
public class BirthDate {
    private LocalDate birthDate;

    public BirthDate() {
    }

    public BirthDate(LocalDate birthDate) {
        this.birthDate = Optional.ofNullable(birthDate)
                .orElseThrow(() -> new IllegalArgumentException("birthDate must not be null or empty"));
    }
    public BirthDate(String birthDate) {
        String value = Optional.ofNullable(birthDate)
                .orElseThrow(() -> new IllegalArgumentException("birthDate must not be null or empty"));
        if (value.isEmpty()) {
            throw new IllegalArgumentException("birthDate must not be null or empty");
        }
        this.birthDate = LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
