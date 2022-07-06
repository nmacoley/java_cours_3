public abstract class Personnage {
    protected Terrain terrain;
    protected Position pos;
    protected final long deplacementDelai = 200;
    protected long maintenant;
    protected long dernierDeplacement;
    protected char caractere;
    protected String couleur;

    protected int derniereDirection = -1;

    protected int directionDemandee = -1;

    public Personnage(Position pos, Terrain terrain) {
        this.pos = new Position(pos);
        this.terrain = terrain;

        terrain.entrerSurTuile(pos, this);
        dernierDeplacement = 0;
    }

    public String affichage() {
        return this.couleur + this.caractere;
    }
    abstract void deplacer(int direction);
}
