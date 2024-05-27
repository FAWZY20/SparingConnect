package com.SparringConnect.SparringConnect.model;

import jakarta.persistence.*;

@Entity
@Table(name="utilisateur")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "vehicle_seq", allocationSize = 1)
    private long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private  String prenom;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password", length = 10)
    private String password;

    public User(String nom, String prenom, String mail, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.password = password;
    }

    public User(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
