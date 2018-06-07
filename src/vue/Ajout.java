/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author FionaC
 */
public class Ajout   {

    public Ajout() {
 String[] buttons = { "Fond", "Instrument" };

    int choix = JOptionPane.showOptionDialog(null, "Ajouter quel element?", "Ajout",
        JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[1]);

    System.out.println(choix);
    //faire condition 0 ou 1
    
        JOptionPane nomDialog = new JOptionPane();
        JOptionPane valeurDialog = new JOptionPane();
        JOptionPane affichage = new JOptionPane();
    String nom = nomDialog.showInputDialog(null, "Entrez la clé", "Clé element", JOptionPane.QUESTION_MESSAGE);
    //verifier si deja existant
    double valeur =Double.valueOf(valeurDialog.showInputDialog(null, "Entrez la valeur", "Valeur element", JOptionPane.QUESTION_MESSAGE));
    // verifier si positif
    affichage.showMessageDialog(null, "La clé est " + nom + "\n Valeur: "+ valeur, "Infos de l'ajout", JOptionPane.INFORMATION_MESSAGE);
    

        
    }

}
