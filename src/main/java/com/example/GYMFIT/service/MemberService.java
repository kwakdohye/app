package com.example.GYMFIT.service;


import com.example.GYMFIT.dto.MemberFormDto;
import com.example.GYMFIT.entity.Member;
import com.example.GYMFIT.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    public List<Member> index(){ return memberRepository.findAll();}

    public Member show(Long memId){
        return memberRepository.findById(memId).orElse(null);
    }

    public Member saveMember(Member member){
        return memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public MemberFormDto getMemberDtoList(Long memId){
        //회원 정보 처리
        Member member = memberRepository.findById(memId).orElseThrow(EntityNotFoundException::new);
        //Entity --> Dto
        MemberFormDto memberFormDto = MemberFormDto.of(member);
        return memberFormDto;
    }
    public Long updateMember(MemberFormDto memberFormDto) throws Exception{
        Member member = memberRepository.findById(memberFormDto.getMemId())
                .orElseThrow(EntityNotFoundException::new);
        member.updateMember(memberFormDto);
        return member.getMemId();
    }

}
