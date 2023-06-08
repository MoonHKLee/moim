package lee.moonhyuk.moim.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class MemberId {
    private String memberId;

    public MemberId() {
    }

    public MemberId(String memberId) {
        this.memberId = memberId;
    }
}
