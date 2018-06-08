/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.JOptionPane;
import modele.Instrument;
import modele.Portefeuille;

/**
 *
 * @author FionaC
 */
public class Suppression {

    String[] buttons = {"Fond", "Instrument"};
    int choix;
    JOptionPane nomDialog;
    JOptionPane affichage;
    String nom;

    Portefeuille wallet;

    public Suppression(Portefeuille _wallet) {

        wallet = _wallet;
        nomDialog = new JOptionPane();
        affichage = new JOptionPane();

        choix = JOptionPane.showOptionDialog(null, "Supprimer quel element?", "Suppression",
                JOptionPane.PLAIN_MESSAGE, 0, null, buttons, buttons[1]);

        System.out.println(choix);

        if (choix == 0) {

            if (wallet.getMapFonds().size() != 0) {
                JOptionPane.showMessageDialog(null, "Ce portefeuille n'a pas de fonds.", "Pas de fonds", JOptionPane.ERROR_MESSAGE);

            }

            if (wallet.getMapInstrument().size() != 0) {

                ajoutFond();
            } else {
                JOptionPane.showMessageDialog(null, "Ce portefeuille n'a pas d'instrument.", "Instrument necessaire", JOptionPane.ERROR_MESSAGE);

            }

        } else if (choix == 1) {
            if (wallet.getMapInstrument().size() != 0) {

                ajoutInstrument();
            } else {
                JOptionPane.showMessageDialog(null, "Ce portefeuille n'a pas d'instrument.", "Instrument necessaire", JOptionPane.ERROR_MESSAGE);

            }

        }

    }

    public void ajoutFond() {

        boolean condition = false;
        do {
            nom = nomDialog.showInputDialog(null, "Entrez la clé", "Clé fond", JOptionPane.QUESTION_MESSAGE);
            if (wallet.fondsExist(nom)) {
                condition = true;
                wallet.removeFonds(nom);
            } else {
                JOptionPane.showMessageDialog(null, "Ce fond n'existe pas.", "Clé invalide", JOptionPane.ERROR_MESSAGE);
            }

        } while (!condition);
        affichage.showMessageDialog(null, "Le fond a été supprimé", "Suppression", JOptionPane.INFORMATION_MESSAGE);

    }

    public void ajoutInstrument() {
        boolean condition = false;
        do {
            nom = nomDialog.showInputDialog(null, "Entrez la clé", "Clé instrument", JOptionPane.QUESTION_MESSAGE);
            if (wallet.instrumentExist(nom)) {
                condition = true;
                wallet.removeInstrument(nom);
            } else {
                JOptionPane.showMessageDialog(null, "Cet instrument n'existe pas.", "Clé invalide", JOptionPane.ERROR_MESSAGE);
            }

        } while (!condition);
        affichage.showMessageDialog(null, "L'instrument a été supprimé", "Suppression", JOptionPane.INFORMATION_MESSAGE);

    }
}
