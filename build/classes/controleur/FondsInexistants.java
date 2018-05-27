package controleur;

/**
 * Classe représentant une erreur lors de la recherche d'un fond inexistant.
 * @see modele.Portefeuille
 * @author Marine Foucambert
 * @author Fiona Chuet
 */
public class FondsInexistants extends Exception {

    /**
     * Constructeur par défaut.
     */
    public FondsInexistants() {
        System.out.println("Ce fond n'existe pas!");
    }

}
