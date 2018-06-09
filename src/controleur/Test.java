/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

//Librairies
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modele.*;
import vue.*;

/**
 * Classe pour tester le programme en graphique.
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
    public Test (){
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
        if(e.getSource() == index.getAjout())
        {
            Ajout a = new Ajout(por);
        }
        
        //Suppression
        if(e.getSource() == index.getSupp())
        {
            
        }
        
        //Recherche
        if(e.getSource() == index.getRecherche())
        {

        }
        
        //Sérialisation
        if(e.getSource() == index.getSerial())
        {

        }
        
        //Dé-sérialisation
        if(e.getSource() == index.getDeserial())
        {
            
        }
        
        //Statistiques
        if(e.getSource() == index.getStats())
        {
            
        }
    }
    
    public static void main(String[] args) {
        Test t = new Test();
    }
}
