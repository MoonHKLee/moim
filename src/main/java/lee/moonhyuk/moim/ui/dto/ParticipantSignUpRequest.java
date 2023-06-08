package lee.moonhyuk.moim.ui.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParticipantSignUpRequest {
    private String name;
    private String birthDate;
    private String sex;
    private String memberId;
    private String password;
    private String email;
    private String organization;
}
