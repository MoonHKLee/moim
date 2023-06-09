package lee.moonhyuk.moim.ui.dto;

import lee.moonhyuk.moim.domain.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class SignUpRequest {
    private String name;
    private String birthDate;
    private Sex sex;
    private String memberId;
    private String password;
    private String email;
    private String organization;
    private List<String> allergenList;
    private String introduce;

    private SignUpRequest() {
    }

    @Builder(builderMethodName = "sponsor")
    public SignUpRequest(String name, String birthDate, Sex sex, String memberId, String password, String email, String organization) {
        this.name = name;
        this.birthDate = birthDate;
        if (sex==null) {
            throw new IllegalArgumentException("sex must not be null");
        }
        this.sex = sex;
        this.memberId = memberId;
        this.password = password;
        this.email = email;
        this.organization = organization;
    }

    public static Participant ofParticipant(SignUpRequest request) {
        Participant participant = new Participant();
        participant.setName(new Name(request.getName()));
        participant.setBirthDate(new BirthDate(request.getBirthDate()));
        participant.setSex(request.getSex());
        participant.setMemberId(new MemberId(request.getMemberId()));
        participant.setPassword(new Password(request.getPassword()));
        participant.setEmail(new Email(request.getEmail()));
        participant.setIntroduce(new Introduce(request.getIntroduce()));
        return participant;
    }
}
