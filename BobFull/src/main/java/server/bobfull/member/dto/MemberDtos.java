package server.bobfull.member.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import server.bobfull.member.domain.model.Member;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDtos {

    @Data
    @NoArgsConstructor
    public static class MemberPostRequestDto {
        String nickName;
        String realName;
        String sex;
        String workPlace;
        boolean married;
        String career;
    }

    @Data
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MemberResponse {
        Long memberId;
        String nickName;
        String realName;
        String sex;
        String workPlace;
        boolean married;
        String career;
        String profileUrl;

        public MemberResponse(Member member) {
            this.memberId = member.getId();
            this.nickName = member.getNickName();
            this.realName = member.getRealName();
            this.sex = member.getSex();
            this.workPlace = member.getWorkPlace();
            this.married = member.isMarried();
            this.career = member.getCareer();
            if(member.getProfileUrl().isEmpty()){ this.profileUrl = "url"; }
            else { this.profileUrl = member.getProfileUrl(); }
        }
    }

    @Data
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MemberSelfResponse {
        Long memberId;
        String nickName;
        String realName;
        String sex;
        String workPlace;
        boolean getQeustion;
        boolean oneToOne;
        boolean varified;
        boolean married;
        String career;
        String profileUrl;

        public MemberSelfResponse(Member member) {
            this.memberId = member.getId();
            this.nickName = member.getNickName();
            this.realName = member.getRealName();
            this.sex = member.getSex();
            this.workPlace = member.getWorkPlace();
            this.getQeustion = member.isGetQeustion();
            this.oneToOne = member.isOneToOne();
            this.varified = member.isVarified();
            this.married = member.isMarried();
            this.career = member.getCareer();
            if(member.getProfileUrl().isEmpty()){ this.profileUrl = "url"; }
            else { this.profileUrl = member.getProfileUrl(); }
        }
    }

    @Data
    @NoArgsConstructor
    public static class MemberPutOneToOneDto {
        Long memberId;
        boolean oneToOne; }

    @Data
    @NoArgsConstructor
    public static class MemberPutGetQeustionDto {
        Long memberId;
        boolean getQeustion; }
}
