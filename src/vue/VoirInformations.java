//Package
package vue;

//Ajouter classes
import java.util.HashMap;
import modele.*;

/**
 * Classe pour afficher les informations d'un portefeuille
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
     * @param _por Portefeuille dont on veut afficher les informations
     */
    public VoirInformations (Portefeuille _por){
        por = new Portefeuille(); //Instanciation du portefeuille
        por.setMapFonds(_por.getMapFonds()); //Copie des maps
        por.setMapInstrument(_por.getMapInstrument());
    }
    
    public Portefeuille getPortefeuille(){
        return this.por;
    }
    
    /**
     * Méthode pour afficher les informations de tous les instruments du portefeuille
     */
    public void displayInstrument(){
        for(int i = 0; i < this.getPortefeuille().getMapInstrument().size(); i++){
            
        }
    }
    
    /**
     * Méthode pour afficher 
     */
    public void displayPourcentage(){
        
    }
    
}
