package modele;

/**
 * Classe permettant de comparer deux fonds selon leurs montants respectifs.
 * Implément l'interface Comparable.
 *
 * @see modele.Fonds
 * @author Marine Foucambert
 * @author Fiona Chuet
 */
public class CompareFonds extends Fonds implements Comparable<Fonds> {

    /**
     * Constructeur surchargé créant un fond de référence à partir des
     * informations en paramètre.
     *
     * @param _amount Le montant du fond de référence.
     * @param _key La clé du fond de référence.
     */
    public CompareFonds(double _amount, String _key) {
        super(_amount, _key);
    }

    /**
     * Constructeur surchargé par copie des informations du fond en paramètre.
     *
     * @param fond Le fond de référence.
     */
    public CompareFonds(Fonds fond) {
        super(fond.getAmount(), fond.getKey());
    }

    /**
     * Compare les montants de deux fonds donnés.
     *
     * @param fond Le fond dont le montant est à comparer à celui de référence.
     * @return True si les deux montants sont égaux, false sinon.
     */
    public boolean equals(Fonds fond) {
        return this.getAmount() == fond.getAmount();
    }

    /**
     * Compare le montant d'un fond donné à celui du fond de référence.
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
