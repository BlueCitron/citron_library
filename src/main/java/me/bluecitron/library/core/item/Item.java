package me.bluecitron.library.core.item;

import lombok.Getter;
import lombok.Setter;
import me.bluecitron.library.core.business.Rental;
import me.bluecitron.library.core.business.Reservation;
import me.bluecitron.library.core.category.Category;
import me.bluecitron.library.core.item.exception.InvalidStatusException;
import me.bluecitron.library.core.member.Member;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorColumn
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Category category;

    @NotNull
    private String storageCode;

    private String description;

    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToOne(mappedBy = "item")
    private Rental rental;

    @OneToOne(mappedBy = "item")
    private Reservation reservation;

    /**
     * 1. 아이템 생성
     * 2. 대여
     * 3. 반납
     * 4. 예약
     * 5. 예약취소
     */
    public static Item createItem(String name, Category category, String storageCode, String description, Room room) {
        Item item = new Item();
        item.setCategory(category);
        item.setStorageCode(storageCode);
        item.setDescription(description);
        item.setItemStatus(ItemStatus.AVAILABLE);
        item.setRoom(room);
        item.setRental(null);
        room.addItem(item);
        return item;
    }

    /**
     * 대여
     */
    public void rent(Member member) throws Exception{
        if (itemStatus == ItemStatus.AVAILABLE) {
            Rental rental = Rental.CreateRental(this, member);
            setRental(rental);
            setItemStatus(ItemStatus.RENT);
        } else {
            throw new InvalidStatusException("올바르지 않은 상태 접근입니다.");
        }
    }

    /**
     * 반납
     */
    public void checkout() {
        if (itemStatus == ItemStatus.RENT) {
            setItemStatus(ItemStatus.AVAILABLE);
        } else if (itemStatus == ItemStatus.RESERVATION) {
            setItemStatus(ItemStatus.KEPT);
        }
    }

    /**
     * 예약
     */
    public void reserve(Member member) {
        if (itemStatus == ItemStatus.RENT) {
            Reservation reservation = Reservation.createReservation(this, member);
            setItemStatus(ItemStatus.RESERVATION);
        } else {
            throw new InvalidStatusException("올바르지 않은 상태 접근입니다.");
        }
    }

    /**
     * 예약취소
     */
    public void cancel() {
        if (itemStatus == ItemStatus.RESERVATION) {
            setItemStatus(ItemStatus.RENT);
        } else {
            throw new InvalidStatusException("올바르지 않은 상태 접근입니다.");
        }
    }
}
