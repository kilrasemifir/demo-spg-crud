package fr.kira.formation.spring.democrud.entreprises;

import lombok.Data;

@Data
public class Entreprise {
    private int id;
    private String nom;
    private long capital;

    public Entreprise() {
    }

    public Entreprise(int id, String nom, long capital) {
        this.id = id;
        this.nom = nom;
        this.capital = capital;
    }
}
