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

    public double searchFonds(String key) {
        try{
            if (this.mapFonds.get(key)==null){
                throw new FondsInexistants(); 
            }
                
        Fonds searched = this.mapFonds.get(key);
        return searched.getAmount();
        }catch(FondsInexistants erreur){
            System.out.print("AAAAAAAAAAAA");
            
        }
 return -1;
    }

    public ArrayList<Fonds> searchInstrument(String key) {
        Instrument searched = null;
        try{
            if (this.mapInstrument.get(key)==null){
                throw new InstrumentInexistant(); 
            }
        searched = this.mapInstrument.get(key);
        }catch(InstrumentInexistant erreur){
            System.out.print("Nope"); 
        }

        return searched.getValeurs();
    }

    public void createFonds(String key, double amount) {
  
        try{
        if (searchFonds(key)!=-1){
             throw new FondExistant(); 
        }
         Fonds newFond = new Fonds(amount,key);
        this.mapFonds.put(key, newFond);
        }catch(FondExistant erreur){
            System.out.print("SYKE YOU FOOL"); 
        }
        
       
    }

    public void addFondsToInstrument(Fonds fond) {

        ArrayList<Fonds> valInstru = searchInstrument(fond.getKey());

        valInstru.add(fond);
    }

}
