package com.example.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class VueTestController {

    @GetMapping("/vue-to-jsp")
    public String vueIndex() {
        log.info("vue-to-jsp");

        return "mpa-test";
    }
}
