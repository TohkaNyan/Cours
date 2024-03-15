public class ArbreBinaire {

    private Integer clef;
    private ArbreBinaire gauche;
    private ArbreBinaire droite;

    // Constructeurs
    public ArbreBinaire() {
        this.clef = null;
        this.gauche = null;
        this.droite = null;
    }

    public ArbreBinaire(Integer clef, ArbreBinaire gauche, ArbreBinaire droite) {
        this.clef = clef;
        this.gauche = gauche;
        this.droite = droite;
    }

    // Singleton pour l'arbre vide
    private static ArbreBinaire arbreVide = new ArbreBinaire();

    public static ArbreBinaire getArbreVide() {
        return arbreVide;
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
        return getArbreVide();
    }

    // Méthode récursive pour insérer une valeur dans l'arbre
    public static ArbreBinaire insererValeur(ArbreBinaire arbre, Integer valeur) {
        if (arbre == getArbreVide()) {
            return new ArbreBinaire(valeur, getArbreVide(), getArbreVide());
        }

        if (valeur < arbre.getClef()) {
            arbre.setGauche(insererValeur(arbre.getGauche(), valeur));
        } else if (valeur > arbre.getClef()) {
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

        // Création d'un arbre binaire avec une seule racine
        ArbreBinaire arbreRacine = new ArbreBinaire(10, ArbreBinaire.getArbreVide(), ArbreBinaire.getArbreVide());
        System.out.println("Arbre avec une seule racine (valeur 10) créé.");

        // Création d'un arbre binaire plus complexe
        ArbreBinaire arbreComplexe = new ArbreBinaire(
                5,
                new ArbreBinaire(3, ArbreBinaire.getArbreVide(), ArbreBinaire.getArbreVide()),
                new ArbreBinaire(
                        8,
                        new ArbreBinaire(6, ArbreBinaire.getArbreVide(), ArbreBinaire.getArbreVide()),
                        new ArbreBinaire(9, ArbreBinaire.getArbreVide(), ArbreBinaire.getArbreVide())
                )
        );
        System.out.println("Arbre binaire complexe créé.");

        // Affichage des arbres créés
        System.out.println("\nAffichage des arbres créés :");
        System.out.println("Arbre vide : " + arbre.getClef());
        System.out.println("Arbre avec une seule racine : " + arbreRacine.getClef());
        System.out.println("Arbre complexe :");
        afficherArbre(arbreComplexe);
    }

    // Méthode récursive pour afficher un arbre binaire (parcours infixé)
    public static void afficherArbre(ArbreBinaire arbre) {
        if (arbre != ArbreBinaire.getArbreVide()) {
            afficherArbre(arbre.getGauche());
            System.out.print(arbre.getClef() + " ");
            afficherArbre(arbre.getDroite());
        }
    }
}
