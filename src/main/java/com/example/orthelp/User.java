package com.example.orthelp;
public class User {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String niveau;
    private int sexe;
    private String telephone;
    private String roles;
    private String token;


    // a voir si on affiche telephone email etc
    public User(int id, String nom, String prenom, String email, String password, String niveau, int sexe, String telephone, String roles, String token) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.niveau = niveau;
        this.sexe = sexe;
        this.telephone = telephone;
        this.roles = roles;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNiveau() {
        return niveau;
    }

    public int getSexe() {
        return sexe;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getRoles() {
        return roles;
    }

    public String getToken() {
        return token;
    }
}
