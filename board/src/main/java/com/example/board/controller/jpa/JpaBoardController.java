package com.example.board.controller.jpa;

import com.example.board.entity.jpa.JpaBoard;
import com.example.board.service.jpa.JpaBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/jpaboard")
public class JpaBoardController {

    @Autowired
    private JpaBoardService service;

    @GetMapping("/register")
    public void registerForm (JpaBoard jpaBoard, Model model) throws Exception {
        log.info("register()");
    }

    @GetMapping("/list")
    public void list(Model model) throws Exception {
        log.info("list()");

        model.addAttribute("list", service.list());
        // model.addAttribute("list", null);
    }
}
