package me.bluecitron.library.core.member;

import lombok.Getter;
import lombok.Setter;
import me.bluecitron.library.core.business.Ban;
import me.bluecitron.library.core.business.Rental;
import me.bluecitron.library.core.business.Reservation;
import me.bluecitron.library.core.post.Post;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotNull
    @UniqueElements
    private String account;

    @NotNull
    @UniqueElements
    private String nickname;

    @Email
    @UniqueElements
    private String email;

    private String password;

    @OneToOne(mappedBy = "member")
    private Ban ban;

    @OneToMany(mappedBy = "member")
    private List<Rental> rentals = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    /**
     * 회원가입
     */
    public Member(@NotNull @UniqueElements String account, @NotNull @UniqueElements String nickname, @Email @UniqueElements String email, String password) {
        this.account = account;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }
}
