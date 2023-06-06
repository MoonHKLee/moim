package lee.moonhyuk.moim.domain;

import jakarta.persistence.Inheritance;

import java.util.List;

@Inheritance
public class Participant extends Member {
    private List<Allergen> allergenList;
    private String introduce;
}
