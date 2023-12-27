package com.example.orthelp;

public class Matiere {
    private int id;
    private String nom;

    public Matiere(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}