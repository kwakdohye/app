package com.example.GYMFIT.controller;


import com.example.GYMFIT.dto.MemberFormDto;
import com.example.GYMFIT.entity.Member;
import com.example.GYMFIT.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller //이건 Controller
@RequestMapping("/members") //MemberController의 주소
@RequiredArgsConstructor//필요한 생성자는 알아서 만들어라
public class MemberController {
    @Autowired//memberservice 불러오기
    private final MemberService memberService;

    @GetMapping("/new") //MemberController 의 주소에서 /members/new 페이지
    public String newMember(Model model){
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "/member/memberForm";
    }

    @PostMapping("/new")
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
}
