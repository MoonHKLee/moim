package lee.moonhyuk.moim.domain;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Name {
    private String name;

    public Name() {
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public Name(String name) {
        this.name = name;
    }
}
