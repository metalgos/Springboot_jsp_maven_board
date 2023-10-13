package com.codingrecipe.controller;


import com.codingrecipe.dto.MemberDTO;
import com.codingrecipe.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @GetMapping("/")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "memberlist";
    }

    // /member?id=1
    @GetMapping
    public String findById(@RequestParam("id") Long id, Model model) {
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "memberdetail";
    }


    @GetMapping("/login")
    public String gopage() {

        return "login";
    }

    @PostMapping("/login")
    public String login(MemberDTO memberDTO,
                        HttpSession session) {
        boolean loginResult = memberService.login(memberDTO);
        if (loginResult) {
            session.setAttribute("loginEmail", memberDTO.getMemberEmail());
            return "main";
        } else {
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {

        httpSession.invalidate();

        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateForm(HttpSession session, Model model) {
        // 세션에 저장된 나의 이메일 가져오기
        String loginEmail = (String) session.getAttribute("loginEmail");
        MemberDTO memberDTO = memberService.findByMemberEmail(loginEmail);
        model.addAttribute("member", memberDTO);
        return "memberupdate";
    }

    @PostMapping("/update")
    public String update(MemberDTO memberDTO) {
        boolean result = memberService.update(memberDTO);
        if (result) {
            return "redirect:/member?id=" + memberDTO.getId();
        } else {
            return "index";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        memberService.delete(id);
        return "redirect:/member/";
    }


    @PostMapping("/email-check")
    @ResponseBody
    public String emailCheck(String memberEmail) {
        //System.out.println("memberEmail = " + memberEmail);
        String checkResult = memberService.emailCheck(memberEmail);

        return checkResult;
    }


}
