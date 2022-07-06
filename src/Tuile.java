import java.util.HashSet;
public class Tuile {
    private char caractere;
    private String couleur;
    private boolean traversable;

    private Pacman pacmanSurTuile;
    private HashSet<Fantome> fantomesSurTuile;

    public Tuile(char caractere) {
        this.caractere = caractere;
        this.pacmanSurTuile = null;
        this.fantomesSurTuile = new HashSet<Fantome>();

        switch (caractere) {
            case Caractere.murHorizontal:
            case Caractere.murVertical:
            default:
                traversable = false;
                couleur = Couleur.BLUE;
                break;
            // Ici on ne met pas de break, car on remplace Pacman par une piece et on exécute le cas Piece apres
            case Pacman.CARACTERE_PACMAN:
                this.caractere = Caractere.vide;
            case Caractere.piece:
                traversable = true;
                couleur = Couleur.YELLOW;
                break;
        }
    }

    public String affichage() {
        if (pacmanSurTuile != null) {
            return pacmanSurTuile.affichage();
        } else if (!fantomesSurTuile.isEmpty()) {
            return fantomesSurTuile.iterator().next().affichage();
        }

        return couleur + caractere;
    }

    public void personnageEntreSurTuile(Personnage personnage) {
        if (personnage instanceof Pacman) {
            pacmanSurTuile = (Pacman) personnage;

            if (caractere == Caractere.piece) {
                caractere = Caractere.vide;
                pacmanSurTuile.ramasserPiece();
            }
        } else if (personnage instanceof Fantome) {
            fantomesSurTuile.add((Fantome) personnage);
        }
    }

    public void personnageQuitteTuile(Personnage personnage) {
        if (personnage instanceof Pacman) {
            pacmanSurTuile = null;
        } else if (personnage instanceof Fantome) {
            fantomesSurTuile.remove((Fantome) personnage);
        }
    }

    public boolean estTraversable() {
        return traversable;
    }
}
