package lee.moonhyuk.moim.ui;

import lee.moonhyuk.moim.fixture.Fixture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
public class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSignUp() throws Exception {
        mockMvc.perform(post("/member/participant")
                        .content(Fixture.SIGN_UP.getContent())
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string("success"));

    }
}
