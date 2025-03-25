package dev.layseiras.HelloRecruiter.model.tracker;

import java.time.LocalDateTime;

public class Card {
    private Long id;
    private String vaga; // hello.getVaga
    private String nivel; // hello.getNivel
    private String empresa; // hello.getEmpresa
    private LocalDateTime createdAt;
    private CardStatus status;
    /*private String plataforma;*/

    private User user;

    public Card() {
    }

    public Card(Long id, String vaga, String nivel, String empresa, LocalDateTime createdAt, CardStatus status, User user) {
        this.id = id;
        this.vaga = vaga;
        this.nivel = nivel;
        this.empresa = empresa;
        this.createdAt = createdAt;
        this.status = status;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVaga() {
        return vaga;
    }

    public void setVaga(String vaga) {
        this.vaga = vaga;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
