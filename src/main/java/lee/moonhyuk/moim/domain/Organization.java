package lee.moonhyuk.moim.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Organization {
    private String organization;

    public Organization() {
    }

    public Organization(String organization) {
        this.organization = organization;
    }
}
