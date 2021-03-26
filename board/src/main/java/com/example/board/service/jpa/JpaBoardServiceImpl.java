package com.example.board.service.jpa;

import com.example.board.entity.jpa.JpaBoard;
import com.example.board.repository.jpa.JpaBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JpaBoardServiceImpl implements JpaBoardService {

    @Autowired
    private JpaBoardRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<JpaBoard> list() throws Exception {
        return null;
    }

    @Override
    public void register(JpaBoard jpaBoard) throws Exception {

    }

    @Override
    public JpaBoard read(Long boardNo) throws Exception {
        return null;
    }

    @Override
    public void modify(JpaBoard jpaBoard) throws Exception {

    }

    @Override
    public void remove(Long boardNo) throws Exception {

    }
}
