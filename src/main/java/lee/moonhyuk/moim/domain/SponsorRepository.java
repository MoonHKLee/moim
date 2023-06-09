package lee.moonhyuk.moim.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SponsorRepository extends JpaRepository<Sponsor, Long> {
    Optional<Sponsor> findSponsorByMemberId(String memberId);
}
