package controleur;

/**
 * Classe représentant une erreur lors de la création d'un fond.
 * @see modele.Portefeuille
 * @author Marine Foucambert
 * @author Fiona Chuet
 */
public class FondExistant extends Exception {

    /**
     * Constructeur par défaut.
     */
    public FondExistant() {
        System.out.println("Ce fond existe déja!");
    }

}
