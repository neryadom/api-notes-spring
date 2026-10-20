package org.neryadom.notes.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "note")
public class Note {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @CreationTimestamp
    @Column(name = "created_at", nullable = true, updatable = false)
    private Instant createdAt;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = true, updatable = true)
    private Instant updatedAt;


    @Column(name = "title", nullable = false, updatable = true)
    private String title;
    @Column(name = "content", nullable = true, updatable = true, columnDefinition = "TEXT")
    private String content;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "content_size", nullable = false, updatable = true)
    private int contentSize;

    public Note() {
        this.id = UUID.randomUUID();
    }

    @Builder
    public Note(String title) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.contentSize = 0;
    }

    @Builder
    public Note(String title, String content) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.content = content;
        this.contentSize = this.content.getBytes().length;
    }
}
