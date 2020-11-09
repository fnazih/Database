package biblio.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Emprunteur implements Serializable {
    @Id
    private int numEmp;
    private String nom;
    private int nbLivresEmp;

    public Emprunteur() { }

    public Emprunteur(int numemp, String nom, int nblivresemp) {
        this.nom = nom;
        this.numEmp = numemp;
        this.nbLivresEmp = nblivresemp;
    }

    public int getNumEmp() { return numEmp; }

    public void setNumEmp(int numemp) { this.numEmp = numemp; }

    public String getNom() { return nom; }

    public void setNom(String newNom) { this.nom = newNom; }

    public int getNbLivresEmp() { return nbLivresEmp; }

    public void setNbLivresEmp(int newNbLivresEmp) { this.nbLivresEmp = newNbLivresEmp; }

}
