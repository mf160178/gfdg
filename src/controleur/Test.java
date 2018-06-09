/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

//Librairies
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.*;
import vue.*;

/**
 * Classe pour tester le programme en graphique.
 *
 * @author Marine Foucambert
 * @author Fiona Chuet
 */
public class Test implements ActionListener {

    /**
     * Portefeuille.
     */
    public static Portefeuille por;

    /**
     * Menu.
     */
    public static Menu index;

    /**
     * Constructeur par défaut.
     */
    public Test() {
        //Instanciation des attributs
        por = new Portefeuille();
        index = new Menu();

        //Ajout des actions listener
        index.getAjout().addActionListener(this);
        index.getSupp().addActionListener(this);
        index.getRecherche().addActionListener(this);
        index.getSerial().addActionListener(this);
        index.getDeserial().addActionListener(this);
        index.getStats().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Ajout
        if (e.getSource() == index.getAjout()) {
            try {
                Ajout a = new Ajout(por);
            } catch (FondsInexistants ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //Suppression
        if (e.getSource() == index.getSupp()) {
            Suppression s = new Suppression(por);
        }

        //Recherche
        if (e.getSource() == index.getRecherche()) {
            try {
                Recherche r = new Recherche(por);
            } catch (InstrumentInexistant ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FondsInexistants ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //Sérialisation
<<<<<<< HEAD
        if (e.getSource() == index.getSerial()) {

=======
        if(e.getSource() == index.getSerial())
        {
            Serialisation serial = new Serialisation(por);
>>>>>>> 8d063842a1e000e77775ac1aee64ed27f5837a00
        }

        //Dé-sérialisation
<<<<<<< HEAD
        if (e.getSource() == index.getDeserial()) {

=======
        if(e.getSource() == index.getDeserial())
        {
            Deserialisation deserial = new Deserialisation(por);
            por = deserial.getDeserial();
>>>>>>> 8d063842a1e000e77775ac1aee64ed27f5837a00
        }

        //Statistiques
        if (e.getSource() == index.getStats()) {
            Statistiques stats = new Statistiques(por);
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
    }
}
