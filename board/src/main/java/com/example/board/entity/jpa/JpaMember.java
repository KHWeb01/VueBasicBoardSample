package com.example.board.entity.jpa;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = "memberNo")
@ToString
@Entity
@Table(name = "member")
public class JpaMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;

    @NonNull
    @Column(length = 64)
    private String userId;

    @NonNull
    @Column(length = 64)
    private String password;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    // CascadeType.ALL는 DB를 제어할때 업데이트, 삭제 등등에 대한 정보를 제어할 수 있게 한다.
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private List<JpaMemberAuth> authList = new ArrayList<JpaMemberAuth>();

    public void addAuth (JpaMemberAuth auth) {
        authList.add(auth);
    }

    public void clearAuthList () {
        authList.clear();
    }
}
