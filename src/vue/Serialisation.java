/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.JOptionPane;
import modele.*;

/**
 * Classe permettant de faire l'interface entre l'utilisateur et le programme pour la sérialisation
 * @author Marine Foucambert
 * @author Fiona Chuet
 */
public class Serialisation {
<<<<<<< HEAD

=======
    
    /**
     * Portefeuille à sérialiser.
     */
    Portefeuille wallet;
    
    /**
     * Constructeur surchargé. Copie le portefeuille en paramètre.
     */
    public Serialisation(Portefeuille _wallet){
        //Copie du portefeuille en paramètre
        wallet=_wallet;
        
        //Sérialisation dans le fichier "portefeuille.serial"
        Serial serial = new Serial(wallet);
        serial.serialiser("portefeuille");
        
        //Afficher une boite de dialogue
        JOptionPane.showMessageDialog(null, "Portefeuille sérialisé!");
    }
    
>>>>>>> 8d063842a1e000e77775ac1aee64ed27f5837a00
}
