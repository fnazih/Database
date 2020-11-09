package biblio.interfaces;

import biblio.entities.Livre;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IInfosLivre {
    List<biblio.entities.Livre> lister();

    Livre trouverParIsbn(String isbn);
}
