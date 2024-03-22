package com.example.GYMFIT.controller;


import com.example.GYMFIT.dto.MemberFormDto;
import com.example.GYMFIT.entity.Member;
import com.example.GYMFIT.service.MemberService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;


@Controller //이건 Controller

@RequestMapping("/members") //MemberController 의 주소
@RequiredArgsConstructor//필요한 생성자는 알아서 만들어라
public class MemberController {
    @Autowired//memberservice 불러오기
    private final MemberService memberService;

    @GetMapping("/new") //멤버 추가하기
    public String newMember(Model model){
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "/member/memberForm";
    }


    @PostMapping("/new") //멤버 추가하기
    public String newMemberPost( MemberFormDto memberFormDto,
                                BindingResult bindingResult, Model model){ //bindingresult는 memberForm에서 th:if="${#fields.hasErrors절
        if(bindingResult.hasErrors()){
            System.out.println("bindingResult.hasErrors()발생");
            return "/member/memberForm";
        }
        try{
            Member member = Member.createMember(memberFormDto);
            memberService.saveMember(member);
        }catch (IllegalStateException e){
            System.out.println("IllegalStateException 발생");
            model.addAttribute("errorMessage", e.getMessage());
            return "/member/memberForm";
        }finally {
            System.out.println("finally redirect");
            return "redirect:/"; //성공하면 루트로 가라
        }
    }

    @GetMapping(value = "/member/{memId}")  //한명씩 조회하기
    public String memDto(@PathVariable("memId") Long memId, Model model) {
        try {
            MemberFormDto memberFormDto = memberService.getMemberDtoList(memId);
            model.addAttribute("memberFormDto", memberFormDto);
            return "/member/memberForm";
        } catch (EntityNotFoundException e) {
            model.addAttribute("errorMessage", "해당 회원 없음");
            model.addAttribute("memberFormDto", new MemberFormDto());
            return "/member/memberForm";
        }
    }

    @PostMapping("/member/{memId}")
    public String updateMember(MemberFormDto memberFormDto,
                               BindingResult bindingResult,
                               Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errorMessage","바인딩 오류");
            return "/member/memberForm";
        }
        try{
            memberService.updateMember(memberFormDto);
            return"redirect:/";
        }catch (Exception e){
            model.addAttribute("errorMessage","Exception 발생");
            return "/member/memberForm";
        }

    }
}
