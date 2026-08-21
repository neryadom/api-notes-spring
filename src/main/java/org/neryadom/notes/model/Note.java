package org.neryadom.notes.model;

import java.util.UUID;

public class Note {

    private String id;
    private String title;
    private String content;

    public Note(String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
    }

    public Note(String title, String content) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
