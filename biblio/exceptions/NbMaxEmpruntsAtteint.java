package biblio.exceptions;

import biblio.entities.Emprunteur;

public class NbMaxEmpruntsAtteint extends Exception {
    public NbMaxEmpruntsAtteint(Emprunteur emprunteur, int nbMaxEmprunts) {
        super(
                String.format(
                        "L'emprunteur %d (%s) a atteint le nombre maximal d'emprunts autorise (%d)",
                        emprunteur.getNumEmp(),
                        emprunteur.getNom(),
                        nbMaxEmprunts
                )
        );
    }
}
