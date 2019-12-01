package me.bluecitron.library.core.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "BOOK")
public class Book extends Item {
    private String author;      // 저자
    private String publisher;   // 발행자
    private String shape;       // 형태
    private String isbn;        // ISBN
    private String chongseo;    // 총서
    private String jugi;        // 주기
    private String bunryu;      // 분류기호
}

