package com.example.GYMFIT.service;


import com.example.GYMFIT.entity.Member;
import com.example.GYMFIT.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;



    public Member saveMember(Member member){
        return memberRepository.save(member);
    }


}
