/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.JOptionPane;
import modele.Portefeuille;

/**
 *
 * @author FionaC
 */
public class Ajout {

    String[] buttons = {"Fond", "Instrument"};
    int choix;
    JOptionPane nomDialog;
    JOptionPane valeurDialog;
    JOptionPane affichage;
    String nom;
    double valeur;
    Portefeuille wallet;

    public Ajout(Portefeuille _wallet) {

        wallet = _wallet;
        nomDialog = new JOptionPane();
        affichage = new JOptionPane();
    
        choix = JOptionPane.showOptionDialog(null, "Ajouter quel element?", "Ajout",
                JOptionPane.PLAIN_MESSAGE, 0, null, buttons, buttons[1]);

        System.out.println(choix);

        if (choix == 0) {
            valeur = -1;

            valeurDialog = new JOptionPane();

            ajoutFond();
        } else if (choix == 1) {
            ajoutInstrument();
        }

    }

    public void ajoutFond() {

        boolean condition = false;
        do{
        nom = nomDialog.showInputDialog(null, "Entrez la clé", "Clé fond", JOptionPane.QUESTION_MESSAGE);
        if (!wallet.fondsExist(nom)) {
            condition=true;
            do {
                String value = valeurDialog.showInputDialog(null, "Entrez la valeur", "Valeur fond", JOptionPane.QUESTION_MESSAGE);
                if (!value.isEmpty()) {
                    valeur = Double.valueOf(value);
                }
            } while (valeur < 0);
        } else {
            JOptionPane.showMessageDialog(null,"Ce fond existe deja.","Clé invalide",JOptionPane.ERROR_MESSAGE);
        }
        
        }while(!condition);
        affichage.showMessageDialog(null, "La clé est " + nom + "\nValeur: " + valeur, "Infos de l'ajout", JOptionPane.INFORMATION_MESSAGE);

    }

    public void ajoutInstrument() {
        nom = nomDialog.showInputDialog(null, "Entrez la clé", "Clé instrument", JOptionPane.QUESTION_MESSAGE);
        //verifier si deja existant
        affichage.showMessageDialog(null, "La clé est " + nom, "Infos de l'ajout", JOptionPane.INFORMATION_MESSAGE);

    }
}
