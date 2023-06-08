package lee.moonhyuk.moim.ui;

import lee.moonhyuk.moim.ui.dto.ParticipantSignUpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @PostMapping("/member/participant")
    public String signUp(@RequestBody ParticipantSignUpRequest signUpRequest) {
        return "success";
    }
}
