package lee.moonhyuk.moim.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Participant extends Member {
    @OneToMany(mappedBy = "participant")
    private List<Allergen> allergenList;
    @Embedded
    private Introduce introduce;

    public Participant() {
    }

    public Participant(List<Allergen> allergenList, Introduce introduce) {
        this.allergenList = allergenList;
        this.introduce = introduce;
    }

    public Participant(Long seq, Name name, BirthDate birthDate, Sex sex, MemberId memberId, Password password, Email email, List<Allergen> allergenList, Introduce introduce) {
        super(seq, name, birthDate, sex, memberId, password, email);
        this.allergenList = allergenList;
        this.introduce = introduce;
    }

    public Participant(String name, LocalDate birthDate, Sex sex, String memberId, String password, String email, List<Allergen> allergenList, String introduce) {
        super(name, birthDate, sex, memberId, password, email);
        this.allergenList = allergenList;
        if (allergenList == null) {
            this.allergenList = new ArrayList<>();
        }
        this.introduce = new Introduce(introduce);
    }


}
