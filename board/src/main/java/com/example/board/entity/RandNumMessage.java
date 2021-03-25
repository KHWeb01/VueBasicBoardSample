package com.example.board.entity;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class RandNumMessage {
    private final static Random random = new Random();
    private Integer randNumber;

    public RandNumMessage () {
        this.randNumber = random.nextInt(32) + 3;

        log.info("random: " + randNumber);
    }

    public Integer getRandNumber () {
        return randNumber;
    }
}
