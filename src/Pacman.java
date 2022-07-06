import static java.awt.event.KeyEvent.*;
public class Pacman extends Personnage {
    private int nombrePieces;
    public static final char CARACTERE_PACMAN = 'P';
    public Pacman(Position pos, Terrain terrain) {
        super(pos, terrain);

        this.caractere = CARACTERE_PACMAN;
        this.couleur = Couleur.YELLOW;
        this.nombrePieces = 0;
    }
    private Position coordonneesDansDirection(int direction) {
        Position newPos = new Position(pos);
        switch (direction) {
            case VK_UP:
                newPos.i--;
                break;
            case VK_LEFT:
                newPos.j--;
                break;
            case VK_DOWN:
                newPos.i++;
                break;
            case VK_RIGHT:
                newPos.j++;
                break;
            default:
                return null;
        }

        return newPos;
    }
    private boolean directionPossible(int direction) {
        if (direction < 0)
            return false;

        Position newPos = coordonneesDansDirection(direction);
        return terrain.deplacementPossible(newPos);
    }
    private void allerVers(int direction) {
        terrain.quitterTuile(pos, this);
        pos = coordonneesDansDirection(direction);
        terrain.entrerSurTuile(pos, this);
        dernierDeplacement = maintenant;
    }
    @Override
    public void deplacer(int nouvelleDirection) {
        maintenant = System.currentTimeMillis();
        if (nouvelleDirection != -1){
            directionDemandee = nouvelleDirection;
        }
        if (maintenant - dernierDeplacement < deplacementDelai)
            return;

        if (directionPossible(directionDemandee) && directionDemandee != -1){
            allerVers(directionDemandee);
            derniereDirection = directionDemandee;
        }

        else if (derniereDirection != -1 && directionPossible(derniereDirection)) {
            allerVers(derniereDirection);
        }
    }

    public void ramasserPiece() {
        nombrePieces++;
    }

    public int getNombrePieces() {
        return nombrePieces;
    }
}
