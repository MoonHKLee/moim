package lee.moonhyuk.moim.service;

import lee.moonhyuk.moim.domain.*;
import lee.moonhyuk.moim.ui.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final AllergenRepository allergenRepository;
    private final FoodRepository foodRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public Member signUpParticipant(SignUpRequest signUpRequest) {
        Participant request = SignUpRequest.of(signUpRequest);
        String password = request.getPassword();
        request.setPassword(new Password(passwordEncoder.encode(password)));
        Participant participant = memberRepository.save(request);
        List<Food> foods = signUpRequest.getAllergenList()
                .stream()
                .map(foodRepository::findFoodByName)
                .toList();
        foods.forEach(v->allergenRepository.save(new Allergen(participant,v)));
        return memberRepository.save(SignUpRequest.of(signUpRequest));
    }

    @Transactional(readOnly = true)
    public Member findMemberBySeq(Long memberSeq) {
        return memberRepository.findById(memberSeq).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }
}
