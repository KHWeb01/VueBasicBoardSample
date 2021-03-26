package com.example.board.repository.jpa;

import com.example.board.entity.jpa.JpaBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBoardRepository extends JpaRepository<JpaBoard, Long> {

}
