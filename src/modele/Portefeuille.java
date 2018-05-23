/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import controleur.FondExistant;
import controleur.FondsInexistants;
import controleur.InstrumentInexistant;
import java.util.ArrayList;
import java.util.HashMap;

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

    public double searchFonds(String key) {
        try {
            if (!fondsExist(key)) {
                throw new FondsInexistants();
            }
            Fonds searched = this.mapFonds.get(key);
            return searched.getAmount();
        } catch (FondsInexistants erreur) {
            System.out.print("searchFonds");

        }
        return -1;
    }

    public ArrayList<Fonds> searchInstrument(String key) {
        Instrument searched = null;
        try {
            if (this.mapInstrument.get(key) == null) {
                throw new InstrumentInexistant();
            }
            searched = this.mapInstrument.get(key);
        } catch (InstrumentInexistant erreur) {
            System.out.print("searchInstrument");
        }

        return searched.getValeurs();
    }

    public void createFonds(String key, double amount) {

        try {

            if (fondsExist(key)) {
                throw new FondExistant();
            } else {
                Fonds newFond = new Fonds(amount, key);
                this.mapFonds.put(key, newFond);
            }
        } catch (FondExistant erreur) {
            System.out.print("createFonds");
        }

    }

    public void addFondsToInstrument(Fonds fond) {

        ArrayList<Fonds> valInstru = searchInstrument(fond.getKey());

        valInstru.add(fond);
    }

    public void removeFonds(String key) {

        try {
            if (searchFonds(key) == -1) {
                throw new FondsInexistants();
            }
            this.mapFonds.remove(key);
        } catch (FondsInexistants erreur) {
            System.out.print("removeFonds");
        }
    }

    public void removeInstrument(String key) {

        try {
            if (searchInstrument(key) == null) {
                throw new FondsInexistants();
            }
            this.mapInstrument.get(key).valeurs.clear();
            this.mapInstrument.remove(key);
        } catch (FondsInexistants erreur) {
            System.out.print("removeInstru");
        }
    }

}
