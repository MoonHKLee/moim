package lee.moonhyuk.moim.auth;

import lee.moonhyuk.moim.ui.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest credentials) {
        String token = loginService.authenticate(credentials.getMemberId(), credentials.getPassword());
        return ResponseEntity.ok().header("Authorization", "Bearer " + token).build();
    }
}
