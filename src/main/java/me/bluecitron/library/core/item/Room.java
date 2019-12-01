package me.bluecitron.library.core.item;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Room {

    @Id
    @GeneratedValue
    @Column(name = "room_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "room")
    private List<Item> items = new ArrayList<>();

    @Column(columnDefinition = "integer default 0")
    private Integer itemCount;

    public void addItem(Item item) {
        items.add(item);
        itemCount++;
    }
}
