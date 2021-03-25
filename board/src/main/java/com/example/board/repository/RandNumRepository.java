package com.example.board.repository;

import com.example.board.entity.RandNumMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class RandNumRepository {

    public RandNumMessage getRandom () {
        log.info("Repository getRandom()");

        return new RandNumMessage();
    }
}
