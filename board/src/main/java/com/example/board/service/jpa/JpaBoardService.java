package com.example.board.service.jpa;

import com.example.board.entity.jpa.JpaBoard;

import java.util.List;

public interface JpaBoardService {

    public List<JpaBoard> list() throws Exception;

    public void register(JpaBoard jpaBoard) throws Exception;

    public JpaBoard read(Long boardNo) throws Exception;

    public void modify(JpaBoard jpaBoard) throws Exception;

    public void remove(Long boardNo) throws Exception;
}
