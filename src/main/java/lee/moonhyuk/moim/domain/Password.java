package lee.moonhyuk.moim.domain;

import javax.persistence.Embeddable;
import lombok.Getter;

import java.util.Optional;

@Embeddable
@Getter
public class Password {
    private String password;

    public Password() {
    }

    public Password(String password) {
        String value = Optional.ofNullable(password)
                .orElseThrow(() -> new IllegalArgumentException("password must not be null or empty"));
        if (value.isEmpty()) {
            throw new IllegalArgumentException("password must not be null or empty");
        }
        if (value.length() < 12) {
            throw new IllegalArgumentException("password must be at least 12 characters");
        }
        //비밀번호 1개의 대문자 숫자 특수기호 포함
        if (!value.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{12,}$")) {
            throw new IllegalArgumentException("password must be at least 12 characters and include at least one uppercase letter, one number, and one special character");
        }
        this.password = password;
    }

}
