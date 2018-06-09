package modele;

/**
 * Classe représentant un fond, définis par un montant et une clé.
 *
 * @author Marine Foucambert
 * @author Fiona Chuet
 */
import java.io.Serializable;

public class Fonds implements Comparable<Fonds>, Serializable {

    private static final long serialVersionUID = 42L;

    /**
     * Montant du fond.
     */
    private double amount;

    /**
     * Clé décrivant le fond.
     */
    private String key;

    /**
     * Constructeur surchargé.
     *
     * @param _amount Le montant du fond à créer.
     * @param _key La clé décrivant le fond à créer.
     */
    public Fonds(double _amount, String _key) {
        this.amount = _amount;
        this.key = _key;
    }

    /**
     * Setter de la clé du fond.
     *
     * @param _key Nouvelle clé du fond.
     */
    public void setKey(String _key) {
        this.key = _key;
    }

    /**
     * Getter de la clé du fond.
     *
     * @return La clé du fond.
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Setter du montant du fond.
     *
     * @param _amount Le nouveau montant du fond.
     */
    public void setAmount(double _amount) {
        if (_amount >= 0) {
            this.amount = _amount;
        } else {
            System.out.println("Indiquer un fond positif!");
        }
    }

    /**
     * Getter du montant du fond.
     *
     * @return Le montant du fond.
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * Compare les montants de deux fonds deux à deux.
     *
     * @param fond Le fond dont le montant est à comparer.
     * @return -1 si le fmontant de référence est inférieur à celui donné, 0 si
     * ils sont égaux, 1 si le montant de référence est supérieur.
     */
    @Override
    public int compareTo(Fonds fond) {
        if (this.equals(fond)) {
            return 0;
        } else if (this.getAmount() > fond.getAmount()) {
            return 1;
        }
        return -1;
    }
}
