package vue;

//Librairies
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import modele.*;

/**
 * Classe faisant l'interface entre l'utilisateur et le programme pour la
 * sérialisation d'un portefeuille.
 *
 * @author Marine
 * @author Fiona Chuet Source:
 * https://codes-sources.commentcamarche.net/source/54993-exemple-d-utilisation-d-un-jtextpane
 */
public class Statistiques {

    private JOptionPane nomDialog;
    private JOptionPane valeurDialog;
    private JOptionPane affichage;
    private String nom;
    private double valeur;

    private String[] buttons = {"Instruments du portefeuille", "Fonds d'un instruments", "Pourcentage d'un instrument par rapport à un fond"};
    private int choix;
    private Portefeuille wallet;
    private JTextPane stats;
    private JFrame f;
    private VoirInformations vue;
    private SimpleAttributeSet style_normal;

    /**
     * Constructeur par défaut.
     */
    public Statistiques(Portefeuille _wallet) {
        //Récupérer le portefeuille par copie
        wallet = _wallet;

        //On vérifie de suite si le portefeuille en paramètre possède des instruments et des fonds
        if (wallet.getMapInstrument().size() != 0) {
            //Instanciation des élements Swing
            nomDialog = new JOptionPane();
            affichage = new JOptionPane();
            vue = new VoirInformations(wallet);

            //Configuration de la fenêtre 
            f = new JFrame("Statistiques");
            f.setSize(300, 400);
            f.setLocationRelativeTo(null);
            f.setResizable(false);

            //Configuration du JTextPane
            stats = new JTextPane();
            stats.setEditable(false);
            //Style du texte
            style_normal = new SimpleAttributeSet();
            StyleConstants.setFontFamily(style_normal, "Calibri");
            StyleConstants.setFontSize(style_normal, 16);

            //Choix de l'utilisateur
            choix = JOptionPane.showOptionDialog(null, "Que souhaitez-vous visualiser?", "Statistiques",
                    JOptionPane.PLAIN_MESSAGE, 0, null, buttons, buttons[1]);

            //Actions à faire en fonction du choix
            //Instruments du portfeuille
            if (choix == 0) {
                this.viewDisplayInstrument();
            } //Fonds d'un instrument donné
            else if (choix == 1) {
                this.viewDisplayFondsInstrument();
            } //Pourcentage d'un instrument par rapport à un fond donnée
            else {
                this.viewDisplayPourcentage();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Aucune statistique disponible !", "Portfeuille vide", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Méthode faisant l'interface entre l'utilisateur et le programme pour
     * afficher les instruments du portefeuille.
     */
    public void viewDisplayInstrument() {
        //Récupérer les résultats
        String results = vue.displayInstrument();

        //Ajouter le texte au JTextPane
        try {
            //Récupérer le style du document
            StyledDocument doc = stats.getStyledDocument();

            /*
            * Insertion d'une chaine de caractères dans le document
            * insertString : position de départ dans le document (doc.getLength ajoute à la fin texte à ajouter style pour le texte à ajouter
             */
            doc.insertString(doc.getLength(), results, style_normal);

        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        //Ajouter l'élement à un scroll
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(stats, null);

        //Ajouter l'élement à la frame
        f.add(scroll);
        f.setVisible(true);

    }

    /**
     * Méthode faisant l'interface entre l'utilisateur et le programme pour
     * afficher les fonds d'un instrument donné.
     */
    public void viewDisplayFondsInstrument() {
        //Booléen de la conditon
        boolean condition = false;
        
        //On vérifie que la clé entrée est valide
        do {
            nom = nomDialog.showInputDialog(null, "Entrez la clé", "Clé instrument", JOptionPane.QUESTION_MESSAGE);
            if (!wallet.instrumentExist(nom)) {
                condition = true;
                JOptionPane.showMessageDialog(null, "Cet instrument n'existe pas.", "Clé invalide", JOptionPane.ERROR_MESSAGE);
            } 
        } while (condition);
        
        //Récupérer les résultats
        String results = vue.displayFondsInstrument(nom);

        //Ajouter le texte au JTextPane
        try {
            //Récupérer le style du document
            StyledDocument doc = stats.getStyledDocument();

            /*
            * Insertion d'une chaine de caractères dans le document
            * insertString : position de départ dans le document (doc.getLength ajoute à la fin texte à ajouter style pour le texte à ajouter
             */
            doc.insertString(doc.getLength(), results, style_normal);

        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        //Ajouter l'élement à un scroll
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(stats, null);

        //Ajouter l'élement à la frame
        f.add(scroll);
        f.setVisible(true);
        
    }

    /**
     * Méthode faisant l'interface entre l'utilisateur et le programme pour
     * afficher le pourventage d'un instrument par rapport à un fond.
     */
    public void viewDisplayPourcentage() {
        //Booléen de la conditon
        boolean condition = false;
        
        //On vérifie que la clé entrée est valide
        do {
            nom = nomDialog.showInputDialog(null, "Entrez la clé", "Clé d'un fond", JOptionPane.QUESTION_MESSAGE);
            if (!wallet.fondsExist(nom)) {
                condition = true;
                JOptionPane.showMessageDialog(null, "Ce fond n'existe pas.", "Clé invalide", JOptionPane.ERROR_MESSAGE);
            } 
        } while (condition);
        
        //Récupérer les résultats
        String results = vue.displayPourcentage(nom);

        //Afficher le résultat
        affichage.showMessageDialog(null, results, "Résultat du pourcentage", JOptionPane.INFORMATION_MESSAGE);
        
    }
}
