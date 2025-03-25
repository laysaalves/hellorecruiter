package dev.layseiras.HelloRecruiter.model.tracker;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String email; // obrigatoriamente unico
    private String displayName; // pego diretamente do auth
    private LocalDateTime createdAt;

    public User() {
    }

    public User(Long id, String email, String displayName, LocalDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.displayName = displayName;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
