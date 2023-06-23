package server.bobfull.member.infrastructure;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import server.bobfull.member.domain.model.Member;
import server.bobfull.member.dto.MemberDtos.MemberPostRequestDto;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    @PersistenceContext
    private final EntityManager em;

    public Optional<Member> saveMember(MemberPostRequestDto memberPostRequestDto) {
        try {
            findByNick(memberPostRequestDto.getNickName()).ifPresent(m -> {
                throw new IllegalStateException();
            });
            Member member = Member.create(memberPostRequestDto);
            em.persist(member);
            return Optional.of(member);
        } catch (IllegalStateException e) {
            return Optional.empty();
        }
    }

    public Optional<Member> findByNick(String nick){
        try {
            Member member = em.createQuery("SELECT m FROM Member m WHERE m.nickName = :nickName", Member.class)
                    .setParameter("nickName", nick)
                    .getSingleResult();
            return Optional.of(member);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public Optional<Member> findByMemberId(Long memberId) {
        try {
            Member member = em.createQuery("SELECT m FROM Member m WHERE m.id = :id", Member.class)
                    .setParameter("id", memberId)
                    .getSingleResult();
            return Optional.of(member);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public Member updateMemberGetQuestion(Member member, boolean getQuestion) {
        member.setGetQeustion(getQuestion);
        em.merge(member);
        return member;
    }

    public Member updateMemberOneToOne(Member member, boolean OneToOne) {
        member.setOneToOne(OneToOne);
        em.merge(member);
        return member;
    }

    public List<Member> findAll() {
        return em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();
    }

    public void deleteMember(Member member) {
        em.remove(member);
    }
}
