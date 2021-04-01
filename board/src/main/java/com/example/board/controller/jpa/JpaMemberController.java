package com.example.board.controller.jpa;

import com.example.board.entity.jpa.JpaMember;
import com.example.board.entity.jpa.JpaMemberAuth;
import com.example.board.repository.jpa.JpaMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/member")
public class JpaMemberController {

    @Autowired
    JpaMemberRepository repository;

    @GetMapping("/register")
    public String getMemberRegister (JpaMember jpaMember, Model model) {
        log.info("getMemberRegister()");

        return "/member/register";
    }

    @PostMapping("/register")
    public String register (JpaMember jpaMember, Model model) {
        log.info("post - register()");

        JpaMember memberEntity = new JpaMember();

        memberEntity.setUserId(jpaMember.getUserId());
        memberEntity.setPassword(jpaMember.getPassword());

        JpaMemberAuth memberAuth = new JpaMemberAuth();
        memberAuth.setAuth("ROLE_MEMBER");

        memberEntity.addAuth(memberAuth);

        repository.save(memberEntity);

        model.addAttribute("msg", "회원 가입이 성공적으로 완료되었습니다.");

        return "/member/success";
    }
}
