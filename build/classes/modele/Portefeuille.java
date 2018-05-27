package modele;

//Librairies
import controleur.ErreurRecherche;
import controleur.FondExistant;
import controleur.FondsInexistants;
import controleur.InstrumentInexistant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe représentant un portefeuille.
 * @author Marine Foucambert
 * @author Fiona Chuet
 */
public class Portefeuille {

    /**
     * HashMap des fonds du portefeuille.
     * @see modele.Fonds
     */
    HashMap<String, Fonds> mapFonds;
    
    /**
     * HashMap des instruments du portfeuille.
     * @see modele.Instrument
     */
    HashMap<String, Instrument> mapInstrument;

    /**
     * Contructeur par défaut.
     */
    public Portefeuille() {
        mapFonds = new HashMap<String, Fonds>();
        mapInstrument = new HashMap<String, Instrument>();
    }

    /**
     * Getter de la map des fonds.
     * @return La hashmap de fonds.
     */
    public HashMap<String, Fonds> getMapFonds() {
        return this.mapFonds;
    }

    /**
     * Getter de la map des instruments.
     * @return La hashmap d'intruments.
     */
    public HashMap<String, Instrument> getMapInstrument() {
        return this.mapInstrument;
    }

    /**
     * Setter de la map des fonds par clonage de la map en paramètre.
     * @param _mapfonds La nouvelle map de fonds.
     */
    public void setMapFonds(HashMap<String, Fonds> _mapfonds) {
        HashMap<String, Fonds> clone = (HashMap<String, Fonds>) _mapfonds.clone();
        this.mapFonds = clone;
    }

    /**
     * Setter de la map des intruments par clonage de la map en paramètre.
     * @param _mapinstrument La nouvelle map d'instruments.
     */
    public void setMapInstrument(HashMap<String, Instrument> _mapinstrument) {
        HashMap<String, Instrument> clone = (HashMap<String, Instrument>) _mapinstrument.clone();
        this.mapInstrument = clone;
    }

    /**
     * Détermine si un fond donné existe dans la hashmap de fonds.
     * @param key La clé du fond à rechercher.
     * @return True si le fond existe, false si le fond n'existe pas.
     */
    public boolean fondsExist(String key) {
        return this.mapFonds.get(key) != null;
    }

    /**
     * Recherche un fond dans la map des fonds.
     * @param key La clé du fond à rechercher.
     * @return Le montant du fond trouvé.
     * @throws FondsInexistants Si le fond n'a pas été trouvé.
     * @see controleur.FondsInexistants
     */
    public double searchFonds(String key) throws FondsInexistants {
        try {
            if (!fondsExist(key)) {
                throw new ErreurRecherche();
            }
            Fonds searched = this.mapFonds.get(key);
            return searched.getAmount();
        } catch (ErreurRecherche erreur) {
            System.out.print("searchFond: ");
            throw new FondsInexistants();
        }
    }

    /**
     * Recherche un instrument dans la map des instruments.
     * @param key La clé de l'instrument à rechercher.
     * @return La liste de fonds de l'instrument trouvé.
     * @throws InstrumentInexistant Si l'instrument n'a pas été trouvé.
     * @see controleur.InstrumentInexistant
     */
    public ArrayList<Fonds> searchInstrument(String key) throws InstrumentInexistant {
        Instrument searched = null;
        try {
            if (this.mapInstrument.get(key) == null) {
                throw new ErreurRecherche();
            }
            searched = this.mapInstrument.get(key);
        } catch (ErreurRecherche erreur) {
            System.out.print("searchInstrument: ");
            throw new InstrumentInexistant();
        }

        return searched.getValeurs();
    }

    /**
     * Créer un fond et l'ajoute à la hashmap des fonds du portefeuille.
     * @param key La clé du fond à créer.
     * @param amount Le montant du fond à créer.
     * @see modele.Fonds
     */
    public void createFonds(String key, double amount) {
        //Si on n'utilise pas au préalable la fonction searchFonds() pour déterminer si le nouveau fond à ajouter existe déjà dans le main,
        //cette méthode génère une exception FondExistant qui indique à l'utilisateur que le fond à ajouter existe déjà.
        try {
            if (fondsExist(key)) {
                throw new FondExistant();
            } else {
                Fonds newFond = new Fonds(amount, key);
                this.mapFonds.put(key, newFond);
                System.out.println("Nouveau fond ajouté! Clé: " + key + "; valeur: " + amount + "\n");
            }
        } catch (FondExistant erreur) {
            System.out.println("createFonds: impossible d'ajouter un fond déjà existant!");
        }
    }
    
    /**
     * Ajoute un nouvel instrument à la hashmap des intruments.
     * @param instrument L'instrument à ajouter.
     * @see modele.Instrument
     */
    public void addInstrument(Instrument instrument){
        this.mapInstrument.put(instrument.getKey(), instrument);
        System.out.println("Nouvel instrument ajouté! Clé: " + instrument.getKey() + "\n");
    }

    /**
     * Ajoute un fond à un instrument du portefeuille.
     * @param keyIns La clé de l'instrument auquel on souhaite ajouter le fond.
     * @param fond Le fond à ajouter à l'instrument.
     */
    public void addFondsToInstrument(String keyIns, Fonds fond) {
        //Si on n'utilise pas au préalable la fonction searchInstrument() pour déterminer si l'instrument auquel on doit ajouter le fond existe dans le main,
        //cette méthode génère une exception InstrumentInexistant qui indique à l'utilisateur que l'instrument donné n'existe pas.
        ArrayList<Fonds> valIns = new ArrayList();
        try {
            valIns = this.searchInstrument(keyIns); //On regarde si l'instrument existe
            Instrument in = this.getMapInstrument().get(keyIns); //On récupère l'instrument par sa clé
            in.addFonds(fond); //On ajoute le fond à sa collection
            System.out.println("Le fond " + fond.getKey() + " de valeur " + fond.getAmount() + " a été ajouté à l'instrument " + in.getKey());
        } catch (InstrumentInexistant ex) {
            System.out.println("addFondsToInstrument: impossible d'ajouter un fond à un instrument inexistant!");
        }
    }

    /**
     * Supprime un fond de la hashmap des fonds du portefeuille.
     * @param key La clé du fond à supprimer.
     */
    public void removeFonds(String key) {

        try {
            if (searchFonds(key) == -1) {
                throw new FondsInexistants();
            }
            this.mapFonds.remove(key);
            System.out.println("Le fond " + key + " a été supprimé!");
        } catch (FondsInexistants erreur) {
            System.out.println("removeFonds: impossible de supprimer un fond qui n'existe pas!");
        }
    }

    /**
     * Supprime un instrument de la hashmap des intruments du portefeuille.
     * @param key La clé de l'instrument à supprimer.
     */
    public void removeInstrument(String key) {

        try {
            if (searchInstrument(key) == null) {
                throw new InstrumentInexistant();
            }
            this.mapInstrument.get(key).valeurs.clear();
            this.mapInstrument.remove(key);
            System.out.println("L'intrument " + key + " a été supprimé!");
        } catch (InstrumentInexistant ex) {
            System.out.println("removeInstrument: impossible de supprimer un instrument qui n'existe pas!");
        }
    }

}
