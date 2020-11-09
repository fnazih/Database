package biblio.implementations;

import biblio.entities.Livre;
import biblio.interfaces.IInfosLivre;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class InfosLivre implements IInfosLivre {
    @PersistenceContext(unitName = "persistenceBiblio")
    protected EntityManager em;

    @Override
    public List<Livre> lister() {
        TypedQuery<biblio.entities.Livre> query = em.createNamedQuery("Livre.lister", biblio.entities.Livre.class);
        return query.getResultList();
    }

    @Override
    public Livre trouverParIsbn(String isbn) {
        TypedQuery<biblio.entities.Livre> query = em.createNamedQuery("Livre.trouverParIsbn", Livre.class);
        query.setParameter("isbn", isbn);
        return query.getSingleResult();
    }
}
