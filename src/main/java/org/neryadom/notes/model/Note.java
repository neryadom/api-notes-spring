package org.neryadom.notes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@Getter
public class Note {

    @Id
    private UUID id;
    private String title;
    private String content;

    public Note() {
        this.id = UUID.randomUUID();
    }

    @Builder
    public Note(String title) {
        this.id = UUID.randomUUID();
        this.title = title;
    }

    @Builder
    public Note(String title, String content) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.content = content;
    }

}
