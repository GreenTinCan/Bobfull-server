package server.bobfull.member.domain.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import server.bobfull.common.model.BaseTimeEntity;

import javax.persistence.*;
import java.util.ArrayList;
import server.bobfull.member.dto.MemberDtos;


@Setter
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
public class Member extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "nick_name", unique = true)
    private String nickName;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "sex")
    private String sex;

    @Column(name = "work_place")
    private String workPlace;

    @Column(name = "get_question")
    @ColumnDefault("false")
    private boolean getQeustion;

    @Column(name = "one_to_one")
    @ColumnDefault("false")
    private boolean oneToOne;

    @Column(name = "married")
    private boolean married;

    @Column(name = "varified")
    @ColumnDefault("false")
    private boolean varified;

    @Column(name = "profile_url")
    private String profileUrl = "url";

    private String career; //only Eng.

//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//    private List<Gather> gathers = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//    private List<RoomMember> roomMembers = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Feed> feeds = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<FeedLike> feedLikes = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Comment> comments = new ArrayList<>();

    @Builder
    private Member(Long id,
                   String nickName,
                   String realName,
                   String sex,
                   String workPlace,
                   boolean getQeustion,
                   boolean oneToOne,
                   boolean married,
                   boolean varified,
                   String career){
        this.id = id;
        this.nickName = nickName;
        this.realName = realName;
        this.sex = sex;
        this.workPlace = workPlace;
        this.getQeustion = getQeustion;
        this.oneToOne = oneToOne;
        this.married = married;
        this.varified = varified;
        this.career = career;
    }

    public static Member create(String nickName,
                                String realName,
                                String sex,
                                String workPlace,
                                boolean married,
                                String career) {
        return Member.builder()
                .nickName(nickName)
                .realName(realName)
                .sex(sex)
                .workPlace(workPlace)
                .married(married)
                .career(career)
                .build();
    }

    public static Member create(MemberDtos.MemberPostRequestDto memberPostRequestDto) {
        return Member.builder()
                .nickName(memberPostRequestDto.getNickName())
                .realName(memberPostRequestDto.getRealName())
                .sex(memberPostRequestDto.getSex())
                .workPlace(memberPostRequestDto.getWorkPlace())
                .married(memberPostRequestDto.isMarried())
                .career(memberPostRequestDto.getCareer())
                .build();
    }
}
