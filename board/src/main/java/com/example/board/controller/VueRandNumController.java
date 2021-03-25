package com.example.board.controller;

import com.example.board.entity.RandNumMessage;
import com.example.board.service.VueRandNumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class VueRandNumController {

    @Autowired
    private VueRandNumService service;

    @GetMapping("/random")
    public ResponseEntity<RandNumMessage> getRandom () {
        log.info("Vue to Spring & Spring to Vue");

        RandNumMessage randNum = service.getRandom();

        return ResponseEntity.ok(randNum);
    }
}
