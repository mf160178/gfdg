/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Marine1
 */
public class Instrument {

    ArrayList<Fonds> valeurs;
    String key;

    public Instrument(String _key) {
        this.key = _key;
        this.valeurs = new ArrayList<Fonds>();
    }

    public void setKey(String _key) {
        this.key = _key;
    }

    public String getKey() {
        return this.key;
    }

    public void setValeurs(ArrayList<Fonds> _valeurs) {
        this.valeurs = _valeurs;
    }

    public ArrayList<Fonds> getValeurs() {
        return this.valeurs;
    }

    /* // exception index out of inbounds
        public Fonds getValeurAt(int index) {
    
        return this.valeurs.get(index);
    }*/
    public void addFonds(Fonds fond) {
        this.valeurs.add(fond);
    }

    public void trierFonds() {
        Collections.sort(valeurs);

    }
}
