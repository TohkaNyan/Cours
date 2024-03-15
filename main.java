public class ArbreBinaire {

    // Attributs de la classe
    private Integer clef;  // La valeur stockée dans le nœud
    private ArbreBinaire gauche;  // Le sous-arbre gauche
    private ArbreBinaire droite;  // Le sous-arbre droit

    // Constructeurs
    public ArbreBinaire() {
        // Crée un arbre vide
        this.clef = null;
        this.gauche = null;
        this.droite = null;
    }

    public ArbreBinaire(Integer clef, ArbreBinaire gauche, ArbreBinaire droite) {
        // Crée un nœud avec la valeur, le sous-arbre gauche et le sous-arbre droit donnés
        this.clef = clef;
        this.gauche = gauche;
        this.droite = droite;
    }

    // Singleton pour l'arbre vide
    private static ArbreBinaire arbreVide = new ArbreBinaire();

    public static ArbreBinaire getArbreVide() {
        return arbreVide;  // Retourne l'instance de l'arbre vide
    }

    // Getters et setters
    public Integer getClef() {
        return clef;
    }

    public void setClef(Integer clef) {
        this.clef = clef;
    }

    public ArbreBinaire getGauche() {
        return gauche;
    }

    public void setGauche(ArbreBinaire gauche) {
        this.gauche = gauche;
    }

    public ArbreBinaire getDroite() {
        return droite;
    }

    public void setDroite(ArbreBinaire droite) {
        this.droite = droite;
    }

    // Méthode creer pour retourner l'arbre vide
    public static ArbreBinaire creer() {
        return getArbreVide();  // Retourne l'arbre vide
    }

    // Méthode récursive pour insérer une valeur dans l'arbre
    public static ArbreBinaire insererValeur(ArbreBinaire arbre, Integer valeur) {
        // Si l'arbre est vide, créer un nouveau nœud avec la valeur donnée
        if (arbre == getArbreVide()) {
            return new ArbreBinaire(valeur, getArbreVide(), getArbreVide());
        }

        // Si la valeur est inférieure à la clé de l'arbre, insérer à gauche
        if (valeur < arbre.getClef()) {
            arbre.setGauche(insererValeur(arbre.getGauche(), valeur));
        }
        // Sinon, insérer à droite
        else if (valeur > arbre.getClef()) {
            arbre.setDroite(insererValeur(arbre.getDroite(), valeur));
        }

        return arbre;
    }

    // Méthode récursive pour afficher l'arbre (parcours infixé)
    public static void afficherArbre(ArbreBinaire arbre) {
        if (arbre != getArbreVide()) {
            afficherArbre(arbre.getGauche());
            System.out.print(arbre.getClef() + " ");
            afficherArbre(arbre.getDroite());
        }
    }
}

public class Main {

    public static void main(String[] args) {
        // Création d'un arbre binaire vide
        ArbreBinaire arbre = ArbreBinaire.creer();
        System.out.println("Arbre vide créé.");

        // Insertion de quelques valeurs dans l'arbre
        arbre = ArbreBinaire.insererValeur(arbre, 5);
        arbre = ArbreBinaire.insererValeur(arbre, 3);
        arbre = ArbreBinaire.insererValeur(arbre, 7);
        arbre = ArbreBinaire.insererValeur(arbre, 1);
        arbre = ArbreBinaire.insererValeur(arbre, 4);
        arbre = ArbreBinaire.insererValeur(arbre, 6);
        arbre = ArbreBinaire.insererValeur(arbre, 9);
        System.out.println("Valeurs insérées dans l'arbre.");

        // Affichage de l'arbre après l'insertion des valeurs
        System.out.println("\nAffichage de l'arbre après l'insertion des valeurs :");
        ArbreBinaire.afficherArbre(arbre);
    }
}
