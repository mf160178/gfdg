/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.JOptionPane;
import modele.Portefeuille;
import modele.Serial;

/**
 *
 * @author Marine Foucambert
 * @author Fiona Chuet
 */
public class Deserialisation {
        /**
     * Portefeuille à sérialiser.
     */
    Portefeuille wallet;
    
    /**
     * Objet pour désérialiser
     */
    Serial serial;
    
    /**
     * Constructeur surchargé. Copie le portefeuille en paramètre.
     */
    public Deserialisation(Portefeuille _wallet){
        //Copie du portefeuille en paramètre
        wallet=_wallet;
        
        //Sérialisation dans le fichier "portefeuille.serial"
        serial = new Serial(wallet);
    }
    
    /**
     * Désérialisation
     * @return Portefeuille désérialisé.
     */
    public Portefeuille getDeserial(){
        //Désérialiser
        Portefeuille por = serial.deserialiser("portefeuille");
        
        //Afficher une boite de dialogue
        JOptionPane.showMessageDialog(null, "Portefeuille dé-sérialisé!");
        
        //Retourner le portefeuille désérialisé
        return por;
    }
}
