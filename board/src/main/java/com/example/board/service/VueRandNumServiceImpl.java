package com.example.board.service;

import com.example.board.entity.RandNumMessage;
import com.example.board.repository.RandNumRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VueRandNumServiceImpl implements VueRandNumService {

    @Autowired
    private RandNumRepository repository;

    @Override
    public RandNumMessage getRandom() {
        log.info("Service getRandom()");

        return repository.getRandom();
    }
}
