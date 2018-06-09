package controleur;

/**
 * Classe représentant une erreur lors de la recherche d'un instrument
 * inexistant.
 *
 * @see modele.Portefeuille
 * @author Marine Foucambert
 * @author Fiona Chuet
 */
public class InstrumentInexistant extends Exception {

    /**
     * Constructeur par défaut.
     */
    public InstrumentInexistant() {
        System.out.println("Cet instrument n'existe pas!");

    }
}
