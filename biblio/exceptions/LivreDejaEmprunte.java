package biblio.exceptions;

import biblio.entities.Livre;

public class LivreDejaEmprunte extends Exception {
    public LivreDejaEmprunte(Livre livre) {
        super(
                String.format(
                        "Le livre %s (%s) est indisponible",
                        livre.getIsbn(),
                        livre.getTitre()
                )
        );
    }
}
