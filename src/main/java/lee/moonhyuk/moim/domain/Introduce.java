package lee.moonhyuk.moim.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Introduce {
    private String introduce;

    public Introduce() {
    }

    public Introduce(String introduce) {
        this.introduce = introduce;
    }
}
