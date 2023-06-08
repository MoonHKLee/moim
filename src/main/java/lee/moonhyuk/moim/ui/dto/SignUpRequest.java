package lee.moonhyuk.moim.ui.dto;

import lee.moonhyuk.moim.domain.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public static Participant of(SignUpRequest request) {
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
