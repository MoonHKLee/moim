package lee.moonhyuk.moim.service;

import lee.moonhyuk.moim.domain.Member;
import lee.moonhyuk.moim.domain.MemberRepository;
import lee.moonhyuk.moim.ui.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Member signUpParticipant(SignUpRequest signUpRequest) {
        return memberRepository.save(SignUpRequest.of(signUpRequest));
    }

    @Transactional(readOnly = true)
    public Member findMemberBySeq(Long memberSeq) {
        return memberRepository.findById(memberSeq).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }
}
