package me.bluecitron.library.core.business;

import me.bluecitron.library.core.member.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ban {

    @Id
    @GeneratedValue
    @Column(name = "ban_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime bannedUntil;
}
