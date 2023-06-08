package lee.moonhyuk.moim.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Name {
    private String name;

    public Name() {
    }

    public Name(String name) {
        this.name = name;
    }
}
