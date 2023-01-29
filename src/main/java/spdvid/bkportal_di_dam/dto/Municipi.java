package spdvid.bkportal_di_dam.dto;

/**
 *
 * @author Fer
 */
public class Municipi {
    private String nom;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    @Override
    public String toString(){
        return nom;
    }
}
