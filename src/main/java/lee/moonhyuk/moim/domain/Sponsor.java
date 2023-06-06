package lee.moonhyuk.moim.domain;

import jakarta.persistence.Inheritance;

@Inheritance
public class Sponsor extends Member {
    private String organization;
}
