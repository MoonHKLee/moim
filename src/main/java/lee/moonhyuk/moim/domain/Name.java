package lee.moonhyuk.moim.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

import java.util.Objects;
import java.util.Optional;

@Embeddable
@Getter
@Setter
public class Name {
    private String name;

    public Name() {
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public Name(String name) {
        String value = Optional.ofNullable(name)
                .orElseThrow(() -> new IllegalArgumentException("name must not be null or empty"));
        if (value.isEmpty()) {
            throw new IllegalArgumentException("name must not be null or empty");
        }
        this.name = value;
    }
}
