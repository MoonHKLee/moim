package lee.moonhyuk.moim.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Introduce {
    private String introduce;

    public Introduce() {
    }

    public Introduce(String introduce) {
        this.introduce = introduce;
    }
}
