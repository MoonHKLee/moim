package lee.moonhyuk.moim.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Email {
    private String email;

    public Email() {
    }

    public Email(String email) {
        this.email = email;
    }
}
