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
  public CompareFonds(Fonds fond) {
        super(fond.getAmount(), fond.getKey());
    }


    public boolean equals (Fonds fond){
        return this.getAmount()==fond.getAmount();
    }
    
    
    @Override
    public int compareTo(Fonds fond) {
        if (this.equals(fond)){
             return 0;
        }
        else if (this.getAmount() > fond.getAmount()) {
            return 1;
        }
       return -1;
    }

}
