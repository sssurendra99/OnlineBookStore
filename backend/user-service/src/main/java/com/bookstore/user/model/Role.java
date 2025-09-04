package com.bookstore.user.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String name;

    public Role() { }

    public Role(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    @PrePersist
    public void prePersist() {
        if (id == null) id = UUID.randomUUID();
    }

    public UUID getId() { return id; }
    public String getName() { return name; }

    public void setId(UUID id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}
