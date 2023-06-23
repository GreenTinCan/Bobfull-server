package server.bobfull.member.domain.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.bobfull.member.domain.model.Member;
import server.bobfull.member.dto.MemberDtos.MemberPostRequestDto;
import server.bobfull.member.infrastructure.MemberRepository;

import java.util.List;
import java.util.NoSuchElementException;


@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member saveMember(MemberPostRequestDto memberPostRequestDto){
        return memberRepository.saveMember(memberPostRequestDto)
                .orElseThrow(() -> new RuntimeException("Member not saved"));
    }

    public Member findByMemberId(Long memberId){
        return memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new NoSuchElementException("Member not found by memberId :" + memberId));
    }

    public boolean isNickRedundant(String nickName) {
        return memberRepository.findByNick(nickName).isPresent();
    }

    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Transactional
    public void deleteMember(Long id) {
        Member member = findByMemberId(id);
        memberRepository.deleteMember(member);
    }

    @Transactional
    public Member updateOneToOne(Long id, boolean OneToOne) {
        Member member = findByMemberId(id);
        return memberRepository.updateMemberOneToOne(member, OneToOne);
    }

    @Transactional
    public Member updateGetQuestion(Long id, boolean GetQuestion) {
        Member member = findByMemberId(id);
        return memberRepository.updateMemberGetQuestion(member, GetQuestion);
    }

    public boolean isIdExist(Long memberId) {
        return memberRepository.findByMemberId(memberId).isPresent();
    }
}
