package biblio.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "livre_emp")
public class LivreEmp implements Serializable {
    @Id
    private String isbn;
    private String titre;
    private int empruntePar;

    public LivreEmp() {}

    public LivreEmp(String isbn, String titre, int empruntePar) {
        this.isbn = isbn;
        this.titre = titre;
        this.empruntePar = empruntePar;
    }

    public String getIsbn() { return isbn; }

    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitre() { return titre; }

    public void setTitre(String titre){ this.titre = titre; }

    public int getEmpruntePar() { return empruntePar; }

    public void setEmpruntePar(int empruntePar) { this.empruntePar = empruntePar; }
}
