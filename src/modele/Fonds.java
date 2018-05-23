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
public class Fonds {

    private double amount;
    private String key;

    public Fonds(double _amount, String _key) {
        this.amount = _amount;
        this.key = _key;
    }

    public void setKey(String _key) {
        this.key = _key;
    }

    public String getKey() {
        return this.key;
    }

    public void setAmount(double _amount) {
        this.amount = _amount;
    }

    public double getAmount() {
        return this.amount;
    }

}
