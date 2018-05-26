//Package
package vue;

//Ajouter classes
import controleur.FondsInexistants;
import controleur.InstrumentInexistant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.*;

/**
 * Classe pour afficher les informations d'un portefeuille
 *
 * @author Fiona Chuet
 * @author Marine Foucambert
 */
public class VoirInformations {

    /**
     * Portefeuille dont on doit afficher les informations.
     */
    private Portefeuille por;

    /**
     * Constructeur par défaut. Copie le portefeuille en paramètre.
     *
     * @param _por Portefeuille dont on veut afficher les informations
     */
    public VoirInformations(Portefeuille _por) {
        por = _por;
    }

    public Portefeuille getPortefeuille() {
        return this.por;
    }

    /**
     * Affiche les fonds d'un instrument du portefeuille
     * @param keyIns La clé de l'instrument
     */
    public void displayFondsInstrument(String keyIns){
        try {
            this.getPortefeuille().searchInstrument(keyIns);
            Instrument ins = this.getPortefeuille().getMapInstrument().get(keyIns);
            System.out.println("Liste des fonds de l'instrument " + keyIns + ":");
            for(Fonds a : ins.getValeurs()){
                System.out.println("Clé: " + a.getKey() + "; montant: " + a.getAmount());
            }
        } catch (InstrumentInexistant ex) {
            System.out.println("displayFondsIntrument: impossiblme d'afficher les fonds d'un instrument inexistant!");
        }
    }
    
    /**
     * Méthode pour afficher les informations de tous les instruments du
     * portefeuille.
     * Source: https://openclassrooms.com/forum/sujet/parcourir-une-hashmap-82775
     */
    public void displayInstrument() {
        //Variables
        Iterator i = this.getPortefeuille().getMapInstrument().keySet().iterator(); //Création d'un itérateur sur la map d'instrument
        String key = null; //Clé d'un instrument dans la HashMap du portefeuille
        int nombre = 0; //Nombre total de fonds dans un instrument
        double somme = 0; //Somme des fonds d'un instrument

        //Parcours de la HashMap
        while (i.hasNext()) {
            //Récupération des informations relatives à un instrument
            key = (String) i.next(); 
            nombre = this.getPortefeuille().getMapInstrument().get(key).getValeurs().size();
            somme = this.getPortefeuille().getMapInstrument().get(key).sommeFonds();
            
            //Affichage des informations
            System.out.println("Clé de l'instrument: " + key + "\nNombre total de fonds: " + nombre + "\nSomme des fonds: " + somme + "\n"); 
        }
    }

    /**
     * Méthode affichant le pourcentage de chaque instrument pour un fond donné
     * @param key Clé du fond
     */
    public void displayPourcentage(String key) {
        //Variables
        double amount = 0;
        
        try {
            //Récupérer la valeur du fond recherché
            amount = this.getPortefeuille().searchFonds(key);
        } catch (FondsInexistants ex) {
            System.out.println("Impossible d'afficher la valeur d'un fond inexistant!");
        }
        
        //Pour chaque instrument, on affiche le poucentage de la totalité de ses fonds par rapport au fond donné
        Iterator i = this.getPortefeuille().getMapInstrument().keySet().iterator(); //Création d'un itérateur sur la map d'instrument
        String key_inst = null;
        double somme = 0; //Somme des fonds d'un instrument
        double pourcentage = 0; //Pourcentage du fond

        //Parcours de la HashMap
        while (i.hasNext()) {
            //Récupération des informations relatives à un instrument
            key_inst = (String) i.next(); 
            somme = this.getPortefeuille().getMapInstrument().get(key_inst).sommeFonds();
            pourcentage = (amount/somme) * 100;
            
            //Affichage des informations
            System.out.println("Clé de l'instrument: " + key_inst + "\n% par rapport au fond " + key + "(" + amount + "): " + pourcentage + "\n"); 
        }
    }

}
