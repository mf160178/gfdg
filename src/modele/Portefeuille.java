/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import controleur.ErreurRecherche;
import controleur.FondExistant;
import controleur.FondsInexistants;
import controleur.InstrumentInexistant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marine1
 */
public class Portefeuille {

    HashMap<String, Fonds> mapFonds;
    HashMap<String, Instrument> mapInstrument;

    public Portefeuille() {
        mapFonds = new HashMap<String, Fonds>();
        mapInstrument = new HashMap<String, Instrument>();
    }

    public HashMap<String, Fonds> getMapFonds() {
        return this.mapFonds;
    }

    public HashMap<String, Instrument> getMapInstrument() {
        return this.mapInstrument;
    }

    public void setMapFonds(HashMap<String, Fonds> _mapfonds) {
        HashMap<String, Fonds> clone = (HashMap<String, Fonds>) _mapfonds.clone();
        this.mapFonds = clone;
    }

    public void setMapInstrument(HashMap<String, Instrument> _mapinstrument) {
        HashMap<String, Instrument> clone = (HashMap<String, Instrument>) _mapinstrument.clone();
        this.mapInstrument = clone;
    }

    public boolean fondsExist(String key) {
        return this.mapFonds.get(key) != null;
    }

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
    
    public void addInstrument(Instrument instrument){
        this.mapInstrument.put(instrument.getKey(), instrument);
        System.out.println("Nouvel instrument ajouté! Clé: " + instrument.getKey() + "\n");
    }

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
