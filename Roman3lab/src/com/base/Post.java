package com.base;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Post {
    private LocalDate publicationDate;
    private String text;

    public Post(LocalDate publicationDate, String text) {
        this.publicationDate = publicationDate;
        this.text = text;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public String getText() {
        return text;
    }
}
