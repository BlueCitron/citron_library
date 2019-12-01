package me.bluecitron.library.core.business;

import lombok.Getter;
import lombok.Setter;
import me.bluecitron.library.core.item.Item;
import me.bluecitron.library.core.member.Member;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue
    @Column(name = "reservation_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name ="member_id")
    private Member member;

    @OneToOne
    @JoinColumn(name ="item_id")
    private Item item;

    public static Reservation createReservation(Item item, Member member) {
        Reservation reservation = new Reservation();
        reservation.setItem(item);
        reservation.setMember(member);
        return reservation;
    }

}
