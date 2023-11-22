package com.esiii.backendjogodaonca.entities.database;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "jogador")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjogador", nullable = false)
    private Integer id;

    @Size(max = 300)
    @NotNull
    @Column(name = "nome", nullable = false, length = 300)
    private String nome;

    @Size(max = 45)
    @NotNull
    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @Size(max = 300)
    @NotNull
    @Column(name = "email", nullable = false, length = 300)
    private String email;

    @Size(max = 100)
    @NotNull
    @Column(name = "senha", nullable = false, length = 100)
    private String senha;

    @NotNull
    @Column(name = "qntmoedanormal", nullable = false)
    private Integer qntmoedanormal;

    @NotNull
    @Column(name = "qntmoedaespecial", nullable = false)
    private Integer qntmoedaespecial;

    @NotNull
    @Column(name = "nivelatual", nullable = false)
    private Integer nivelatual;

    @NotNull
    @Column(name = "qntvitorias", nullable = false)
    private Integer qntvitorias;

    @NotNull
    @Column(name = "qntvitoriascachorro", nullable = false)
    private Integer qntvitoriascachorro;

    @NotNull
    @Column(name = "qntvitoriasonca", nullable = false)
    private Integer qntvitoriasonca;

    @NotNull
    @Column(name = "qntpartidasjogadas", nullable = false)
    private Integer qntpartidasjogadas;

    @NotNull
    @Column(name = "experiencia", nullable = false)
    private Integer experiencia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getQntmoedanormal() {
        return qntmoedanormal;
    }

    public void setQntmoedanormal(Integer qntmoedanormal) {
        this.qntmoedanormal = qntmoedanormal;
    }

    public Integer getQntmoedaespecial() {
        return qntmoedaespecial;
    }

    public void setQntmoedaespecial(Integer qntmoedaespecial) {
        this.qntmoedaespecial = qntmoedaespecial;
    }

    public Integer getNivelatual() {
        return nivelatual;
    }

    public void setNivelatual(Integer nivelatual) {
        this.nivelatual = nivelatual;
    }

    public Integer getQntvitorias() {
        return qntvitorias;
    }

    public void setQntvitorias(Integer qntvitorias) {
        this.qntvitorias = qntvitorias;
    }

    public Integer getQntvitoriascachorro() {
        return qntvitoriascachorro;
    }

    public void setQntvitoriascachorro(Integer qntvitoriascachorro) {
        this.qntvitoriascachorro = qntvitoriascachorro;
    }

    public Integer getQntvitoriasonca() {
        return qntvitoriasonca;
    }

    public void setQntvitoriasonca(Integer qntvitoriasonca) {
        this.qntvitoriasonca = qntvitoriasonca;
    }

    public Integer getQntpartidasjogadas() {
        return qntpartidasjogadas;
    }

    public void setQntpartidasjogadas(Integer qntpartidasjogadas) {
        this.qntpartidasjogadas = qntpartidasjogadas;
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Integer experiencia) {
        this.experiencia = experiencia;
    }
}