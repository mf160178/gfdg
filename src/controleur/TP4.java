//Package
package controleur;

//Classes à importer
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.*;
import vue.Menu;
import vue.VoirInformations;

/**
 * Classe test.
 * @author Marine Foucambert
 * @author Fiona Chuet
 */
public class TP4 {

    /**
     * Méthode du main.
     * @param args The command line arguments
     */
//    public static void main(String[] args) {
//        //Variables     
//        Portefeuille por = new Portefeuille(); //Création d'un portefeuille vide
//        Scanner scan = new Scanner(System.in);
//
//        //Demande de fond à l'utilisateur
//        System.out.println("***** Question 1.5 : ajout d'un nouveau fond *****");
//        double amount1 = 0;
//        do {
//            System.out.print("Indiquer le montant (positif) d'un fond: ");
//            amount1 = scan.nextDouble();
//        } while (amount1 < 0);
//        System.out.print("Indiquer la clé de ce fond: ");
//        String key1 = scan.next();
//        Fonds fond1 = new Fonds(amount1, key1);
//        
//        //On recherche le fond entré par l'utilisateur, s'il n'existe pas, on l'ajoute à la Map des fonds du portefeuille
//        try {
//            double testAmount = por.searchFonds(key1);
//            System.out.println("Ce fond existe déjà, vous ne pouvez pas l'ajouter!");
//        } catch (FondsInexistants ex) {
//            por.createFonds(key1, amount1); //Le fond entré n'existe pas, on l'ajoute 
//        }
//        
//        //Test de la méthode createFonds sans utiliser la méthode searchFonds au préalable
//        System.out.println("Test de la méthode createFonds sans utiliser la méthode searchFonds au préalable:");
//        System.out.println("On veut ajouter un nouveau fond avec la clé suivante: " + key1);
//        por.createFonds(key1, amount1);
//        System.out.println("Une exception FondExistant a été généré car le fond à ajouter existe déjà dans le portefeuille sous cette clé.\n");
//        
//        //Ajouter un instrument: demander la clé à l'utilisateur
//        System.out.println("***** Question 1.6 : ajout d'un nouvel instrument *****");
//        System.out.print("Indiquer la clé de l'instrument à ajouter: ");
//        String key2 = scan.next();
//        
//        //On recherche si la clé entré par l'utilisateur correspond à un instrument déjà existant dans le portefeuille
//        try {
//            ArrayList<Fonds> testList = new ArrayList();
//            testList = por.searchInstrument(key2);
//        } catch (InstrumentInexistant ex) { //Si l'instrument n'existe pas
//            Instrument in1 = new Instrument(key2); //On l'instancie
//            por.addInstrument(in1);//On l'ajoute à la HashMap des instruments du portefeuille
//            por.addFondsToInstrument(key2, fond1);//On lui ajoute le nouveau fond à a collection
//        }
//        
//        //Test de la méthode addFondsToInstrument sans utiliser la méthode searchInstrument dans le main
//        System.out.println("\nTest de la méthode addFondsToInstrument sans utiliser la méthode searchInstrument dans le main:");
//        System.out.println("On veut ajouter un fond à un instrument qui n'existe pas dans le portefeuille.");
//        String keyTest;
//        do {
//            System.out.print("Entrer la clé d'un instrument (elle doit être différente de la précédente!): ");
//            keyTest = scan.next();
//        } while (keyTest.equals(key2));
//        por.addFondsToInstrument(keyTest, fond1);
//        System.out.println("Une exception InstrumentInexistant a été généré car l'instrument auquel on souhaitait ajouter le fond n'existe pas dans le portefeuille.\n");
//        
//        //Utilisation de l'interface Comparable
//        System.out.println("***** Question 1.8 : interface Comparable *****");
//        System.out.println("Création d'un objet CompareFond implémentant l'interface Comparable<Fonds>.");
//        System.out.println("Fond de référence: " + key1 + " de valeur " + amount1);
//        CompareFonds comp = new CompareFonds(amount1, key1);
//        double amount2 = 0;
//        do {
//            System.out.print("Entrer le montant (positif) du fond à comparer: ");
//            amount2 = scan.nextDouble();
//        } while (amount2 < 0);
//        Fonds fond2 = new Fonds(amount2, "comparer");
//        int resultat = comp.compareTo(fond2);
//        switch(resultat){
//            case -1:
//                System.out.println("Le montant de référence (" + amount1 + ") est inférieur au montant entré (" + amount2 + ").");
//                break;
//            
//            case 0:
//                System.out.println("Les montants sont égaux.");
//                break;
//                
//            case 1:
//                System.out.println("Le montant de référence (" + amount1 + ") est supérieur au montant entré (" + amount2 + ").");
//                break;
//        }
//        
//        //Test méthode de tri et affichage
//        System.out.println("\n***** Question 1.9 : trier les fonds et afficher les informations *****");
//        //Ajout d'autres fonds à l'instrument
//        String key3 = "livres";
//        double amount3 = 149.99;
//        Fonds fond3 = new Fonds(amount3, key3);
//        por.createFonds(key3, amount3);
//        por.addFondsToInstrument(key2, fond3);
//        
//        String key4 = "loto";
//        double amount4 = 1500;
//        Fonds fond4 = new Fonds(amount4, key4);
//        por.createFonds(key4, amount4);
//        por.addFondsToInstrument(key2, fond4);
//        
//        String key5 = "parc";
//        double amount5 = 45;
//        Fonds fond5 = new Fonds(amount5, key5);
//        por.createFonds(key5, amount5);
//        por.addFondsToInstrument(key2, fond5);
//        
//        String key6 = "cadeau";
//        double amount6 = 50;
//        Fonds fond6 = new Fonds(amount6, key6);
//        por.createFonds(key6, amount6);
//        por.addFondsToInstrument(key2, fond6);
//
//        //Afficher les informations
//        VoirInformations vue = new VoirInformations(por);
//        System.out.println("\nInstrument avant tris:");
//        vue.displayFondsInstrument(key2);
//        
//        //Trier les fonds
//        por.getMapInstrument().get(key2).trierFonds();
//        
//        //Affichage après tris
//        System.out.println("\nInstrument après tris:");
//        vue.displayFondsInstrument(key2);
//        
//        //Test méthode de tri et affichage
//        System.out.println("\n***** Question 1.10 : autres méthodes d'affichage *****");
//        System.out.println("Affichage relatif aux instrument du portefeuille:");
//        vue.displayInstrument();
//        System.out.println("Affichage du pourcentage des instruments par rapport au fond " + key1+":");
//        vue.displayPourcentage(key1);
//        
//        //Suppression des fonds et des instruments
//        System.out.println("***** Question 1.7 : suppression d'un fond et d'un instrument *****");
//        //Demande d'informations à l'utilisateur
//        System.out.print("Entrer la clé du fond à supprimer: ");
//        String key7 = scan.next();
//        System.out.print("Entrer la clé de l'instrument à supprimer: ");
//        String key8 = scan.next();
//        //Suppression des fonds et instruments correspondant aux clés rentrées
//        por.removeFonds(key7);
//        por.removeInstrument(key8);
//        
//        //Sérialisation 
//        System.out.println("\n***** Partie 2 - 1 : sérialisation & désérialisation *****");
//        Serial serial = new Serial(por);
//        serial.serialiser("portefeuille");
//        serial.deserialiser("portefeuille");
//        VoirInformations vue2 = new VoirInformations(serial.getPorDeSerial()); //Test pour voir su désérialisation marche
//        vue2.displayInstrument(); //Affficher les informations relatives au portefeuille désérialisé
//
//    }

}
