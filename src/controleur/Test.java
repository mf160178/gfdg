/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.ArrayList;
import java.util.Scanner;
import modele.CompareFonds;
import modele.Fonds;
import modele.Instrument;
import modele.Portefeuille;
import modele.Serial;
import vue.Ajout;
import vue.Menu;
import vue.VoirInformations;

/**
 *
 * @author FionaC
 */
public class Test {
    public static void main(String[] args) {
        Portefeuille portefeuille = new Portefeuille();
        Menu menu = new Menu();
        Ajout pet= new Ajout(portefeuille);
        Ajout petrfe= new Ajout(portefeuille);
    }
}
