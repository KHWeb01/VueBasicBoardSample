package com.example.board.entity.jpa;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(of = "boardNo")
@ToString
@Entity
public class JpaBoard {

    // 아이디 생성 전략
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    private String title;
    private String writer;

    // 구조화되지 않은 대형 데이터 처리(이미지, 비디오도 가능)
    // My 유튜브를 만든다면 필요하지만 난이도가 너무 어려우니 패스
    // 진짜 서비스를 만들고 싶다면 FFMPEG, GSTREAMER 같은 C++ 코덱을 공부해야합니다.
    @Lob
    private String content;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;
}
