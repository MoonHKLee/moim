package lee.moonhyuk.moim.auth;

import lee.moonhyuk.moim.domain.Member;
import lee.moonhyuk.moim.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findMemberByMemberId(username)
                .orElseThrow(() -> new UsernameNotFoundException("유저가 없습니다."));
        return new MemberDetails(member);
    }
}
