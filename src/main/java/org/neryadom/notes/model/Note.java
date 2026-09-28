package org.neryadom.notes.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class Note {
    private String id;
    private String title;
    private String content;

    public Note() {
        this.id = UUID.randomUUID().toString();
    }

    @Builder
    public Note(String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
    }

    @Builder
    public Note(String title, String content) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.content = content;
    }

}
