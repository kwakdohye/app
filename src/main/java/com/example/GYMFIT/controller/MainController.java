package com.example.GYMFIT.controller;

import com.example.GYMFIT.dto.MainMemberDto;
import com.example.GYMFIT.dto.MemberSearchDto;
import com.example.GYMFIT.service.FacilityService;
import com.example.GYMFIT.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/GYMFIT")
@RequiredArgsConstructor
public class MainController {
    private final MemberService memberService;

    @GetMapping(value = {"/"})
    public String memMain(MemberSearchDto memberSearchDto,
                          @PathVariable("page") Optional<Integer> page,
                          Model model){


        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 8);
        Page<MainMemberDto> members = memberService.getMainMemberPage(memberSearchDto, pageable);

        model.addAttribute("members", members);
        model.addAttribute("memberSearchDto", memberSearchDto);
        model.addAttribute("maxPage",10);
        return"member/dashboard";
    }
}
