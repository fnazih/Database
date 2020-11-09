package biblio.implementations;

import biblio.entities.*;
import biblio.exceptions.NbMaxEmpruntsAtteint;
import biblio.interfaces.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GestionEmprunt implements IGestionEmprunt {
    private int MAX_EMPRUNTS = 5;

    @PersistenceContext(unitName = "persistenceBiblio")
    protected EntityManager em;

    @Override
    public void emprunter(int numEmp, String isbn) throws NbMaxEmpruntsAtteint {
        Emprunteur emprunteur = em.find(Emprunteur.class, numEmp);

        if(emprunteur == null) {
            //throws
        }
        else if(emprunteur.getNbLivresEmp() >= MAX_EMPRUNTS) {
            throw new NbMaxEmpruntsAtteint(emprunteur, MAX_EMPRUNTS);
        }

        Livre livre = em.find(Livre.class, isbn);

        if(livre == null) {
            //throws
        } else if(livre.getDispo() == 0) {
            //throws "indisponible"
        }

        //Creation de l'emprunt si tout est ok
        LivreEmp livreEmp = new LivreEmp(livre.getIsbn(), livre.getTitre(), emprunteur.getNumEmp());
        em.persist(livreEmp);

        //MAJ de la dispo du livre
        livre.setDispo(0);
        em.persist(livre);

        //MAj compteur de l'emprunteur
        emprunteur.setNbLivresEmp(emprunteur.getNbLivresEmp() + 1);
        em.persist(emprunteur);
    }

    @Override
    public void rendre(String isbn) {
        LivreEmp livreEmp = em.find(LivreEmp.class, isbn);

        if(livreEmp == null) {
            return;
        }

        //MAJ dispo
        Livre livre = em.find(Livre.class, isbn);
        livre.setDispo(1);
        em.persist(livre);

        //MAJ compteur de l'emprunteur
        Emprunteur emprunteur = em.find(Emprunteur.class, livreEmp.getEmpruntePar());
        emprunteur.setNbLivresEmp(emprunteur.getNbLivresEmp() - 1);
        em.persist(emprunteur);

        //Suppression de l'emprunt
        em.remove(livreEmp);
    }
}
