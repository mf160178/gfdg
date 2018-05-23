//Package
package controleur;

//Classes à importer
import java.util.Scanner;
import modele.*;

/**
 * Classe test.
 *
 * @author Marine Foucambert
 * @author Fiona Chuet
 */
public class TP4 {

    /**
     * Méthode du main.
     *
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        //Variables     
        Portefeuille pet = new Portefeuille(); //Création d'un portefeuille vide
        Scanner scan = new Scanner(System.in);

        //Demande de fond à l'utilisateur
        System.out.println("Indiquer la valeur d'un fond:");
        double amount1 = scan.nextDouble();
        System.out.println("Indiquer la clé de ce fond:");
        String key1 = scan.next();

        //Création et ajout d'un fond dans la Hashmap du portefeuille
        pet.createFonds(key1, amount1);

        pet.searchFonds("oui");

    }

}
