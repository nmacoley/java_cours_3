public class Fantome extends Personnage {
    private static int counter = 0;

    public Fantome(Position pos, Terrain terrain) {
        super(pos, terrain);

        this.caractere = 'F';

        switch(counter) {
            case 0:
                this.couleur = Couleur.RED;
                break;
            case 1:
                this.couleur = Couleur.CYAN;
                break;
            case 2:
                this.couleur = Couleur.GREEN;
                break;
            case 3:
                this.couleur = Couleur.PURPLE;
                break;
            default:
                this.couleur = Couleur.WHITE;
        }


        counter++;
    }
    @Override
    void deplacer(int direction) {

    }
}
