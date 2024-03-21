package com.example.GYMFIT.entity;

import com.example.GYMFIT.dto.MemberFormDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDateTime;

@Entity
@Table(name="member")
@Getter
@Setter
@ToString
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memId; //회원 ID
    @Column
    private String memNm; //회원 이름
    @Column
    private String memBirthDt; //회원 출생일자
    @Column
    private String memCno; //회원 연락처
    @Column
    private String memAdr; //회원 주소
    @Column
    private String memEmlAdr; //회원 Email 주소
    @Column
    private LocalDateTime memRgtDt; //회원 등록일자

//    @Enumerated(EnumType.STRING)
//    private Role role;

    public static Member createMember(MemberFormDto memberFormDto){
        Member member = new Member();
        member.setMemNm(memberFormDto.getMemNm());
        member.setMemBirthDt(memberFormDto.getMemBirthDt());
        member.setMemCno(memberFormDto.getMemCno());
        member.setMemAdr(memberFormDto.getMemAdr());
        member.setMemEmlAdr(memberFormDto.getMemEmlAdr());
        return member;
    }

}
