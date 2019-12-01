package me.bluecitron.library.core.business;

import lombok.Getter;
import lombok.Setter;
import me.bluecitron.library.core.item.Item;
import me.bluecitron.library.core.member.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Rental {

    @Id
    @GeneratedValue
    @Column(name = "rental_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime borrowedAt;
    private LocalDateTime returnedUntil;

    // @Column(columnDefinition = "varchar default 'N'")
    private Boolean returned;

    /**
     *  Rental 생성 메서드
     */
    public static Rental CreateRental(Item item, Member member) {
        Rental rental = new Rental();
        rental.setItem(item);
        rental.setMember(member);
        rental.setBorrowedAt(LocalDateTime.now());
        rental.setReturnedUntil(LocalDateTime.now().plusDays(14));
        rental.setReturned(false);
        return rental;
    }

}
