package lee.moonhyuk.moim.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Email {
    private String email;

    public Email() {
    }

    public Email(String email) {
        this.email = email;
    }
}
