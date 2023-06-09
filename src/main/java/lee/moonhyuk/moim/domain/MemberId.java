package lee.moonhyuk.moim.domain;

import javax.persistence.Embeddable;
import lombok.Getter;

import java.util.Optional;

@Embeddable
@Getter
public class MemberId {
    private String memberId;

    public MemberId() {
    }

    public MemberId(String memberId) {
        String value = Optional.ofNullable(memberId)
                .orElseThrow(() -> new IllegalArgumentException("memberId must not be null or empty"));
        if (value.isEmpty()) {
            throw new IllegalArgumentException("memberId must not be null or empty");
        }
        if (value.length() < 4) {
            throw new IllegalArgumentException("memberId must be longer than 4");
        }
        this.memberId = memberId;
    }
}
