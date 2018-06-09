/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.FondsInexistants;
import controleur.InstrumentInexistant;
import javax.swing.JOptionPane;
import modele.Fonds;
import modele.Instrument;
import modele.Portefeuille;

/**
 *
 * @author FionaC
 */
public class Recherche {

    String[] buttons = {"Fond", "Instrument"};
    int choix;
    JOptionPane nomDialog;
    JOptionPane valeurDialog;
    JOptionPane affichage;
    String nom;
    double valeur;
    Portefeuille wallet;

    public Recherche(Portefeuille _wallet) throws InstrumentInexistant, FondsInexistants {

        wallet = _wallet;
        nomDialog = new JOptionPane();
        affichage = new JOptionPane();

        choix = JOptionPane.showOptionDialog(null, "Rechercher quel element?", "Recherche",
                JOptionPane.PLAIN_MESSAGE, 0, null, buttons, buttons[1]);

        System.out.println(choix);

        if (choix == 0) {
            valeur = -1;

            if (wallet.getMapFonds().size() != 0) {
                JOptionPane.showMessageDialog(null, "Ce portefeuille n'a pas de fonds.", "Pas de fonds", JOptionPane.ERROR_MESSAGE);

            }

            if (wallet.getMapInstrument().size() != 0) {

                rechercheFond();
            } else {
                JOptionPane.showMessageDialog(null, "Ce portefeuille n'a pas d'instrument.", "Instrument necessaire", JOptionPane.ERROR_MESSAGE);

            }

        } else if (choix == 1) {
            if (wallet.getMapInstrument().size() != 0) {

                rechercheInstrument();
            } else {
                JOptionPane.showMessageDialog(null, "Ce portefeuille n'a pas d'instrument.", "Instrument necessaire", JOptionPane.ERROR_MESSAGE);

            }

        }

    }

    public void rechercheFond() throws FondsInexistants {

        boolean condition = false;
        do {
            nom = nomDialog.showInputDialog(null, "Entrez la clé", "Clé fond", JOptionPane.QUESTION_MESSAGE);
            if (wallet.fondsExist(nom)) {
                condition = true;
                Fonds searched = wallet.getFond(nom);
                affichage.showMessageDialog(null, "Fond trouvé: \nClé: " + searched.getKey()+"\nValeur: "+ searched.getAmount(), "Fond", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ce fond n'existe pas.", "Clé invalide", JOptionPane.ERROR_MESSAGE);
            }

        } while (!condition);

    }

    public void rechercheInstrument() throws InstrumentInexistant {
        boolean condition = false;
        do {
            nom = nomDialog.showInputDialog(null, "Entrez la clé", "Clé instrument", JOptionPane.QUESTION_MESSAGE);
            if (wallet.instrumentExist(nom)) {
                condition = true;

                Instrument searched = wallet.getInstrument(nom);
                affichage.showMessageDialog(null, "Instrument trouvé: \nClé: " + searched.getKey(), "Instrument", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Cet instrument n'existe pas.", "Clé invalide", JOptionPane.ERROR_MESSAGE);
            }

        } while (!condition);

    }
}
