package lee.moonhyuk.moim.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import lee.moonhyuk.moim.domain.Member;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static lee.moonhyuk.moim.auth.JWTUtil.HEADER_STRING;
import static lee.moonhyuk.moim.auth.JWTUtil.TOKEN_PREFIX;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        setFilterProcessesUrl("/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            Member credentials = new ObjectMapper().readValue(request.getInputStream(), Member.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(credentials.getMemberId(), credentials.getPassword())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UserDetails userDetails = userDetailsService.loadUserByUsername(authResult.getName());
        String token = jwtUtil.generateToken(userDetails);
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }
}
