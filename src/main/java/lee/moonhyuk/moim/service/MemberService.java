package lee.moonhyuk.moim.service;

import lee.moonhyuk.moim.domain.*;
import lee.moonhyuk.moim.ui.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final ParticipantRepository participantRepository;
    private final SponsorRepository sponsorRepository;
    private final AllergenRepository allergenRepository;
    private final FoodRepository foodRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public Member signUpParticipant(SignUpRequest signUpRequest) {
        Participant request = SignUpRequest.ofParticipant(signUpRequest);
        String password = request.getPassword();
        request.setPassword(new Password(passwordEncoder.encode(password)));
        Participant participant = memberRepository.save(request);
        List<Food> foods = signUpRequest.getAllergenList()
                .stream()
                .map(foodRepository::findFoodByName)
                .toList();
        foods.forEach(v->allergenRepository.save(new Allergen(participant,v)));
        return memberRepository.save(SignUpRequest.ofParticipant(signUpRequest));
    }

    @Transactional(readOnly = true)
    public Member findMemberBySeq(Long memberSeq) {
        return memberRepository.findById(memberSeq).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }

    public Member updateMember(SignUpRequest signUpRequest) {
        Participant request = SignUpRequest.ofParticipant(signUpRequest);
        String password = request.getPassword();
        request.setPassword(new Password(passwordEncoder.encode(password)));
        Participant participant = memberRepository.save(request);
        List<Food> foods = signUpRequest.getAllergenList()
                .stream()
                .map(foodRepository::findFoodByName)
                .toList();
        allergenRepository.deleteAllByParticipant(participant);
        foods.forEach(v->allergenRepository.save(new Allergen(participant,v)));
        return memberRepository.save(SignUpRequest.ofParticipant(signUpRequest));
    }

    public Participant updateToParticipant(SignUpRequest signUpRequest) {
        String memberId = SecurityContextHolder.getContext().getAuthentication().getName();
        Participant participant = participantRepository.findParticipantByMemberId(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        participant.setIntroduce(new Introduce(signUpRequest.getIntroduce()));
        List<Food> foods = signUpRequest.getAllergenList()
                .stream()
                .map(foodRepository::findFoodByName)
                .toList();
        foods.forEach(v->allergenRepository.save(new Allergen(participant,v)));
        return memberRepository.save(SignUpRequest.ofParticipant(signUpRequest));
    }

    public Sponsor updateToSponsor(SignUpRequest signUpRequest) {
        String memberId = SecurityContextHolder.getContext().getAuthentication().getName();
        Sponsor sponsor = sponsorRepository.findSponsorByMemberId(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        sponsor.setOrganization(new Organization(signUpRequest.getOrganization()));
        return memberRepository.save(SignUpRequest.ofSponsor(signUpRequest));
    }

    public SignUpRequest.NoPasswordUserData getMe() {
        String memberId = SecurityContextHolder.getContext().getAuthentication().getName();
        Participant participant = participantRepository.findParticipantByMemberId(memberId)
                .orElseThrow(NoSuchElementException::new);
        Sponsor sponsor = sponsorRepository.findSponsorByMemberId(memberId)
                .orElseThrow(NoSuchElementException::new);
        return SignUpRequest.of(participant, sponsor);
    }
}
