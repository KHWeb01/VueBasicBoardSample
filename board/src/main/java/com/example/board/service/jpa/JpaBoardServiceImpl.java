package com.example.board.service.jpa;

import com.example.board.entity.jpa.JpaBoard;
import com.example.board.repository.jpa.JpaBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
        // findAll이 리스트 전체 찾기
        // 정렬을 하시오 Descent, 그 대상은 boardNo에 해당한다.
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    @Transactional
    public void register(JpaBoard jpaBoard) throws Exception {
        repository.save(jpaBoard);
    }

    @Override
    @Transactional(readOnly = true)
    public JpaBoard read(Long boardNo) throws Exception {
        return repository.getOne(boardNo);
    }

    @Override
    @Transactional
    public void modify(JpaBoard jpaBoard) throws Exception {
        JpaBoard jpaBoardEntity = repository.getOne(jpaBoard.getBoardNo());

        jpaBoardEntity.setTitle(jpaBoard.getTitle());
        jpaBoardEntity.setContent(jpaBoard.getContent());
    }

    @Override
    @Transactional
    public void remove(Long boardNo) throws Exception {
        repository.deleteById(boardNo);
    }
}
