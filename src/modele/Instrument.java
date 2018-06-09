package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe représentant un instrument.
 *
 * @author Marine Foucambert
 * @author Fiona Chuet
 */
public class Instrument implements Serializable {

    private static final long serialVersionUID = 42L;
    /**
     * Liste de fonds de l'instrument.
     *
     * @see modele.Fonds
     */
    ArrayList<Fonds> valeurs;

    /**
     * Clé décrivant l'instrument.
     */
    String key;

    /**
     * Constructeur surchargé.
     *
     * @param _key La clé décrivant l'instrument à créer.
     */
    public Instrument(String _key) {
        this.key = _key;
        this.valeurs = new ArrayList<Fonds>();
    }

    /**
     * Setter de la clé de l'instrument.
     *
     * @param _key Nouvelle clé de l'instrument.
     */
    public void setKey(String _key) {
        this.key = _key;
    }

    /**
     * Getter de la clé de l'instrument.
     *
     * @return La clé de l'instrument.
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Setter de la liste de fonds.
     *
     * @param _valeurs La nouvelle liste de fonds.
     */
    public void setValeurs(ArrayList<Fonds> _valeurs) {
        this.valeurs = _valeurs;
    }

    /**
     * Getter de la liste de fonds.
     *
     * @return La liste de fonds de l'instrument.
     */
    public ArrayList<Fonds> getValeurs() {
        return this.valeurs;
    }

    /**
     * Ajouter un nouveau fond à la liste de fonds.
     *
     * @param fond Le fond à ajouter.
     */
    public void addFonds(Fonds fond) {
        this.valeurs.add(fond);
    }

    /**
     * Trie la liste de fonds par montant croissant.
     */
    public void trierFonds() {
        Collections.sort(valeurs);
    }

    /**
     * Somme les fonds d'un instrument.
     *
     * @return La somme des fonds d'un instrument.
     */
    public double sommeFonds() {
        //Variables
        double somme = 0;

        //Parcours de la liste
        for (Fonds a : this.getValeurs()) {
            somme += a.getAmount();
        }

        //Retourner la somme
        return somme;
    }
}
