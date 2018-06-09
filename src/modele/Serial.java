package modele;

//Librairies
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Classe pour sérialiser des objets du portefeuille.
 *
 * @see modele.Portefeuille
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
    private Portefeuille porToSerial;
    private Portefeuille porDeSerial;

    /**
     * Constructeur surchargé. Instancie le portefeuille en attribut par copie
     * du portefeuille en paramètre.
     *
     * @param _por Le portfeuille à sérialiser/désérialiser.
     */
    public Serial(Portefeuille _por) {
        porToSerial = new Portefeuille();
        porToSerial = _por;
        porDeSerial = null;
    }

    /**
     * Getter du portefeuille désérialisé.
     *
     * @return Portefeuille désérialisé.
     * @see modele.Portefeuille
     */
    public Portefeuille getPorDeSerial() {
        return this.porDeSerial;
    }

    /**
     * Sérialiser un portefeuille.
     *
     * @param file_name Nom du fichier où stocker les hashmap.
     */
    public void serialiser(String file_name) {
        try {
            //Nom du fichier où stocker les informations
            String file = file_name + ".serial";

            //Ouverture d'un flux de sortie vers le fichier en question
            FileOutputStream fos = new FileOutputStream(file);

            //Création d'un "flux objet" avec le flux fichier
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            try {
                //Sérialisation : écriture de l'objet dans le flux de sortie
                oos.writeObject(porToSerial);
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

    /**
     * Désérialiser un portefeuille.
     *
     * @param file_name Nom du fichier où est stocké le portefeuille.
     */
<<<<<<< HEAD
    public void deserialiser(String file_name) {
=======
    public Portefeuille deserialiser(String file_name){
>>>>>>> 8d063842a1e000e77775ac1aee64ed27f5837a00
        try {
            //Nom du fichier où récupérer les informations
            String file = file_name + ".serial";

            //Ouverture d'un flux d'entrée depuis le fichier "personne.serial"
            FileInputStream fis = new FileInputStream(file);

            //Création d'un "flux objet" avec le flux fichier
            ObjectInputStream ois = new ObjectInputStream(fis);

            try {
                // désérialisation : lecture de l'objet depuis le flux d'entrée
                porDeSerial = (Portefeuille) ois.readObject();
            } finally {
                //On ferme les flux
                try {
                    ois.close();
                } finally {
                    fis.close();
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        if (porDeSerial != null) {
            System.out.println("Le portefeuille a été désérialisé!");
            
        }
        return porDeSerial;
    }
}
