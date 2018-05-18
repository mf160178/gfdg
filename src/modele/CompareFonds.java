/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Marine1
 */
public class CompareFonds extends Fonds implements Comparable<Fonds> {

    public CompareFonds(double _amount, String _key) {
        super(_amount, _key);
    }



    public boolean equals (Fonds fond){
        return this.getAmount()==fond.getAmount();
    }
    
    
    @Override
    public int compareTo(Fonds fond) {
        if (this.getAmount() < fond.getAmount()) {
            return -1;
        }
        if (this.getAmount() > fond.getAmount()) {
            return 1;
        }
        return 0;
    }

}
