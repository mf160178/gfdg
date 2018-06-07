/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.JOptionPane;

/**
 *
 * @author FionaC
 */
public class Ajout {

    String[] buttons = {"Fond", "Instrument"};
    int choix;
    JOptionPane nomDialog = new JOptionPane();
    JOptionPane valeurDialog = new JOptionPane();
    JOptionPane affichage = new JOptionPane();
    String nom;
    double valeur;

    public Ajout() {

        choix = JOptionPane.showOptionDialog(null, "Ajouter quel element?", "Ajout",
                JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[1]);

        System.out.println(choix);
        
        if (choix==0)
            ajoutFond();
        else if (choix==1)
            ajoutInstrument();
       
    }
public void ajoutFond(){
     nom = nomDialog.showInputDialog(null, "Entrez la clé", "Clé fond", JOptionPane.QUESTION_MESSAGE);
        //verifier si deja existant
        //        //Demande de fond à l'utilisateur
//        System.out.println("***** Question 1.5 : ajout d'un nouveau fond *****");
//        double amount1 = 0;
//        do {
//            System.out.print("Indiquer le montant (positif) d'un fond: ");
//            amount1 = scan.nextDouble();
//        } while (amount1 < 0);
//        System.out.print("Indiquer la clé de ce fond: ");
//        String key1 = scan.next();
//        Fonds fond1 = new Fonds(amount1, key1);
//        
//        //On recherche le fond entré par l'utilisateur, s'il n'existe pas, on l'ajoute à la Map des fonds du portefeuille
//        try {
//            double testAmount = por.searchFonds(key1);
//            System.out.println("Ce fond existe déjà, vous ne pouvez pas l'ajouter!");
//        } catch (FondsInexistants ex) {
//            por.createFonds(key1, amount1); //Le fond entré n'existe pas, on l'ajoute 
//        }
        valeur = Double.valueOf(valeurDialog.showInputDialog(null, "Entrez la valeur", "Valeur fond", JOptionPane.QUESTION_MESSAGE));
        // verifier si positif
        affichage.showMessageDialog(null, "La clé est " + nom + "\nValeur: " + valeur, "Infos de l'ajout", JOptionPane.INFORMATION_MESSAGE);

    
}
public void ajoutInstrument(){
    nom = nomDialog.showInputDialog(null, "Entrez la clé", "Clé instrument", JOptionPane.QUESTION_MESSAGE);
        //verifier si deja existant
                affichage.showMessageDialog(null, "La clé est " + nom, "Infos de l'ajout", JOptionPane.INFORMATION_MESSAGE);

}
}
