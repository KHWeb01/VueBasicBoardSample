package com.example.board.repository.jpa;

import com.example.board.entity.jpa.JpaMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberRepository extends JpaRepository<JpaMember, Long> {
}
