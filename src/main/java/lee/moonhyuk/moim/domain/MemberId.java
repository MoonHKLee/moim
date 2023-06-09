package lee.moonhyuk.moim.domain;

import jakarta.persistence.Embeddable;

import java.util.Optional;

@Embeddable
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
        this.memberId = memberId;
    }
}
