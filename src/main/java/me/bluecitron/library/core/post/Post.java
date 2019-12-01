package me.bluecitron.library.core.post;

import me.bluecitron.library.core.member.Member;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorColumn
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private PostType postType;

    @NotNull
    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(columnDefinition = "integer default 0")
    private Integer viewCount;
}
