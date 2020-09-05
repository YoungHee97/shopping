package com.shopping.web.member.controller;

import com.shopping.web.member.form.MemberForm;
import com.shopping.web.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String getSignUpPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/member/signUp";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUpPost(HttpServletRequest request, HttpServletResponse response, MemberForm memberForm, RedirectAttributes rttr) throws Exception {
        memberService.insertMember(memberForm);

        rttr.addFlashAttribute("msg", "회원 가입이 완료되었습니다. 로그인 해주세요.");
        return "redirect:/home";
    }
}