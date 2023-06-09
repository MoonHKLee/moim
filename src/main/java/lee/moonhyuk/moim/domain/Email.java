package lee.moonhyuk.moim.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Email {
    private String email;

    public Email() {
    }

    public Email(String email) {
        this.email = email;
    }
}
