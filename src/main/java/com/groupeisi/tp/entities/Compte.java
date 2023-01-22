package com.groupeisi.tp.entities;

import javax.annotation.processing.FilerException;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comptes")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", length = 150, nullable = false)
    private String username;

    @Column(name = "password", length = 150, nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER) // fetch = FetchType.EAGER: permet de charger tous les droit d'un compte
    List<Droit> droits = new ArrayList<Droit>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Droit> getDroits() {
        return droits;
    }

    public void setDroits(List<Droit> droits) {
        this.droits = droits;
    }
}
