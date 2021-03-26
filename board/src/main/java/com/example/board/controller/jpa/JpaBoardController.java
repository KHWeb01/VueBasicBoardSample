package com.example.board.controller.jpa;

import com.example.board.entity.jpa.JpaBoard;
import com.example.board.service.jpa.JpaBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/jpaboard")
public class JpaBoardController {

    @Autowired
    private JpaBoardService service;

    @GetMapping("/register")
    public void registerForm (JpaBoard jpaBoard, Model model) throws Exception {
        log.info("jpa based get register()");
    }

    @PostMapping("/register")
    public String register(JpaBoard jpaBoard, RedirectAttributes rttr) throws Exception {
        log.info("jpa based post register()");

        service.register(jpaBoard);

        rttr.addFlashAttribute("msg", "JPA 기반의 게시판 등록 성공!");

        return "redirect:/jpaboard/list";
    }

    @GetMapping("/list")
    public void list(Model model) throws Exception {
        log.info("list()");

        model.addAttribute("lists", service.list());
        // model.addAttribute("list", null);
    }

    @GetMapping("/read")
    public void read(Long boardNo, Model model) throws Exception {
        log.info("read()");

        model.addAttribute(service.read(boardNo));
    }

    @GetMapping("/modify")
    public void modifyForm(Long boardNo, Model model) throws Exception {
        log.info("modifyForm()");

        model.addAttribute(service.read(boardNo));
    }

    @PostMapping("/modify")
    public String modify(JpaBoard jpaBoard, RedirectAttributes rttr) throws Exception {
        log.info("modify()");

        service.modify(jpaBoard);

        rttr.addFlashAttribute("msg",
                "jpa 기반에서 수정이 성공적으로 완료되었습니다.");

        return "redirect:/jpaboard/list";
    }

    @PostMapping("/remove")
    public String remove(Long boardNo, RedirectAttributes rttr) throws Exception {
        service.remove(boardNo);

        rttr.addFlashAttribute("msg",
                "jpa 기반에서 삭제가 성공적으로 완료되었습니다.");

        return "redirect:/jpaboard/list";
    }
}
