package lee.moonhyuk.moim.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Password {
    private String password;

    public Password() {
    }

    public Password(String password) {
        this.password = password;
    }
}
