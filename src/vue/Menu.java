package vue;

//Librairies
import java.awt.*;
import javax.swing.*;

/**
 * Classe représentant le menu.
 * @author Marine Foucambert
 * @author Fiona Chuet
 */
public class Menu extends JFrame {
    
    /**
     * Panel du menu
     */
    private JPanel panel;
    
    /**
     * Bouton ajout.
     */
    private JButton ajout;
    
    /**
     * Bouton supprimer.
     */
    private JButton supprimer;
    
    /**
     * Bouton recherche.
     */
    private JButton recherche;
    
    /**
     * Bouton sérialiser.
     */
    private JButton serial;
    
    /**
     * Bouton désérialiser.
     */
    private JButton deserial;
    
    /**
     * Bouton statistiques.
     */
    private JButton stats;
    
    /**
     * Constructeur par défaut.
     */
    public Menu(){
        //Propriétés de la fenêtre
        this.setSize(800, 800); //Redimensionner la fenêtre, autrement elle est toute petite
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Indique au programme de se terminer lorsqu'on ferme la fenêtre, 
                                                              //autrement le programme tourne toujours même à fenêtre fermée
        this.setResizable(false); //Autorise le redimensionnement de la fenêtre (à voir)
        this.setLocationRelativeTo(null); //Permet d'afficher la fenêtre au centre de l'écran au démarrage du programme
        this.setLayout(new BorderLayout()); 
        
        //Ajout du panel
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        this.add(panel, BorderLayout.CENTER);
        
        //Instanciation des boutons
        ajout = new JButton("Ajouter");
        supprimer = new JButton("Supprimer");
        recherche = new JButton("Rechercher");
        serial = new JButton("Sérialiser le portefeuille");
        deserial = new JButton("Désérialiser un portefeuille");
        stats = new JButton("Statistiques");
        
        //Contraintes du layout
        GridBagConstraints gbc = new GridBagConstraints();

        //Bouton ajout
        gbc.gridy = 0; //Emplacement (0,0) de la grille virtuelle (tout en haut au milieu)
        gbc.gridwidth = GridBagConstraints.REMAINDER; //Signifie que c'est le dernier élement de sa colonne
        gbc.anchor = GridBagConstraints.CENTER; //Pour centrer l'élèment dans la place qui lui est alloué
        gbc.insets = new Insets(0, 0, 20, 0); //Top Left Bottom Right (padding)
        this.add(this.ajout, gbc); //Ajouter au panel
        
        //Bouton supprimer
        gbc.gridy = 1; //Emplacement (0,0) de la grille virtuelle (tout en haut au milieu)
        gbc.gridwidth = GridBagConstraints.REMAINDER; //Signifie que c'est le dernier élement de sa colonne
        gbc.anchor = GridBagConstraints.CENTER; //Pour centrer l'élèment dans la place qui lui est alloué
        gbc.insets = new Insets(0, 0, 20, 0); //Top Left Bottom Right (padding)
        this.add(this.supprimer, gbc); //Ajouter au panel
        
        //Bouton rechercher
        gbc.gridy = 2; //Emplacement (0,0) de la grille virtuelle (tout en haut au milieu)
        gbc.gridwidth = GridBagConstraints.REMAINDER; //Signifie que c'est le dernier élement de sa colonne
        gbc.anchor = GridBagConstraints.CENTER; //Pour centrer l'élèment dans la place qui lui est alloué
        gbc.insets = new Insets(0, 0, 20, 0); //Top Left Bottom Right (padding)
        this.add(this.recherche, gbc); //Ajouter au panel
        
        //Bouton serial
        gbc.gridy = 3; //Emplacement (0,0) de la grille virtuelle (tout en haut au milieu)
        gbc.gridwidth = GridBagConstraints.REMAINDER; //Signifie que c'est le dernier élement de sa colonne
        gbc.anchor = GridBagConstraints.CENTER; //Pour centrer l'élèment dans la place qui lui est alloué
        gbc.insets = new Insets(0, 0, 20, 0); //Top Left Bottom Right (padding)
        this.add(this.serial, gbc); //Ajouter au panel
        
        //Bouton deserial
        gbc.gridy = 4; //Emplacement (0,0) de la grille virtuelle (tout en haut au milieu)
        gbc.gridwidth = GridBagConstraints.REMAINDER; //Signifie que c'est le dernier élement de sa colonne
        gbc.anchor = GridBagConstraints.CENTER; //Pour centrer l'élèment dans la place qui lui est alloué
        gbc.insets = new Insets(0, 0, 20, 0); //Top Left Bottom Right (padding)
        this.add(this.deserial, gbc); //Ajouter au panel
        
        //Bouton statistiques
        gbc.gridy = 5; //Emplacement (0,0) de la grille virtuelle (tout en haut au milieu)
        gbc.gridwidth = GridBagConstraints.REMAINDER; //Signifie que c'est le dernier élement de sa colonne
        gbc.gridheight = GridBagConstraints.REMAINDER; //Signifie que c'est le dernier élement de sa colonne
        gbc.anchor = GridBagConstraints.CENTER; //Pour centrer l'élèment dans la place qui lui est alloué
        gbc.insets = new Insets(0, 0, 20, 0); //Top Left Bottom Right (padding)
        this.add(this.stats, gbc); //Ajouter au panel
        
        //Rendre visible la fenêtre
        this.setVisible(true);
        
    }
    
}
