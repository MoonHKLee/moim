package lee.moonhyuk.moim.domain;

import javax.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Password {
    private String password;

    public Password() {
    }

    public Password(String password) {
        this.password = password;
    }

}
