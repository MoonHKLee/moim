package lee.moonhyuk.moim.domain;

import jakarta.persistence.*;

@Entity
public class Allergen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    @ManyToOne
    @JoinColumn(name = "participant_seq", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Participant participant;

    @ManyToOne
    private Food food;

    public Allergen() {
    }

    public Allergen(Participant participant, Food food) {
        this.participant = participant;
        this.food = food;
    }
}
