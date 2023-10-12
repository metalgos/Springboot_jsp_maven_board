package com.codingrecipe.controller;


import com.codingrecipe.dto.MemberDTO;
import com.codingrecipe.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;


    @GetMapping("/save")
    public String saveForm() {

        return "membersave";
    }

    @PostMapping("/save")
    public String save(MemberDTO memberDTO) {
        int saveResult = memberService.save(memberDTO);
        if (saveResult > 0) {
            return "login";
        } else {
            return "save";
        }
    }



    @GetMapping("/login")
    public String gopage() {

        return "login";
    }

    @PostMapping("/email-check")
    @ResponseBody
    public  String emailCheck(String memberEmail) {
        //System.out.println("memberEmail = " + memberEmail);
        String checkResult = memberService.emailCheck(memberEmail);

        return checkResult;
    }







}
