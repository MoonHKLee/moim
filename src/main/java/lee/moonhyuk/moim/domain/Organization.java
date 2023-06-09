package lee.moonhyuk.moim.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Organization {
    private String organization;

    public Organization() {
    }

    public Organization(String organization) {
        this.organization = organization;
    }
}
