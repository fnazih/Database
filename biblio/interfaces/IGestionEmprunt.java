package biblio.interfaces;

import biblio.exceptions.NbMaxEmpruntsAtteint;

import javax.ejb.Remote;

@Remote
public interface IGestionEmprunt {
    void emprunter(int numEmp, String isbn) throws NbMaxEmpruntsAtteint;

    void rendre(String isbn);
}
