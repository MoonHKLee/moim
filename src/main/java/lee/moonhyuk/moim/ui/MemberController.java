package lee.moonhyuk.moim.ui;

import lee.moonhyuk.moim.service.MemberService;
import lee.moonhyuk.moim.ui.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member/participant")
    public String signUp(@RequestBody SignUpRequest signUpRequest) {
        memberService.signUpParticipant(signUpRequest);
        return "success";
    }

    @PatchMapping("/member/me")
    public String updateMember(@RequestBody SignUpRequest signUpRequest) {
        memberService.updateMember(signUpRequest);
        return "success";
    }

    @PatchMapping("/member/participant")
    public String updateParticipant(@RequestBody SignUpRequest signUpRequest) {
        memberService.updateToParticipant(signUpRequest);
        return "success";
    }

    @PatchMapping("/member/sponsor")
    public String updateSponsor(@RequestBody SignUpRequest signUpRequest) {
        memberService.updateToSponsor(signUpRequest);
        return "success";
    }

}
