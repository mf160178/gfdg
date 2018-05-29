package modele;

//Librairies
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
        
/**
 * Classe pour sérialiser des objets du portefeuille.
 * @author Fiona Chuet
 * @author Marine Foucambert
 */
public class Serial implements Serializable {
    /**
     * Attribut pour la sérialisation.
     */
    private static final long serialVersionUID = 42L;
    
    /**
     * Portefeuille à sérialiser.
     */
    private Portefeuille por;
    
    /**
     * Constructeur surchargé. Instancie le portefeuille en attribut par copie du portefeuille en paramètre.
     * @param _por Le portfeuille à sérialiser/désérialiser.
     */
    public Serial(Portefeuille _por){
        por = new Portefeuille();
        por = _por;
    }
    
    /**
     * Sérialiser les hashmap d'un portefeuille.
     * @param file Nom du fichier où stocker les hashmap.
     */
    public void serialiser(String file){
        try { 
            //Nom du fichier où stocker les informations
            String name_file = file + ".serial";
            
            //Ouverture d'un flux de sortie vers le fichier en question
            FileOutputStream fos = new FileOutputStream(name_file);
            
            //Création d'un "flux objet" avec le flux fichier
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            try {
                //Sérialisation : écriture de l'objet dans le flux de sortie
                oos.writeObject(por);
                //On vide le tampon
                oos.flush();
                System.out.println("Le portefeuille a ete serialisé!");
            } finally {
                //Fermeture des flux
                try {
                    oos.close();
                } finally {
                    fos.close();
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
