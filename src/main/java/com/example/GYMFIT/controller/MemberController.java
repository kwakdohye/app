package com.example.GYMFIT.controller;


import com.example.GYMFIT.dto.MemberFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller //이건 Controller
@RestController
@RequestMapping("/members") //MemberController의 주소
@RequiredArgsConstructor//필요한 생성자는 알아서 만들어라
public class MemberController {

    @GetMapping("/new")
    public String newMem(Model model){
        model.addAttribute("memberFormDto", new MemberFormDto());
        return"/memberForm";
    }

}
