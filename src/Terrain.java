public class Terrain {
    private String[] terrainOriginal;
    private Tuile[][] terrain;
    private int n;
    private int m;
    Pacman pacman;
    public static final String ANSI_NETTOYAGE = "\033[H\033[2J";
    private boolean changement;
    public Terrain() {
        terrainOriginal = new String[]
                {
                        "|------------||------------|",
                        "|............||............|",
                        "|.----.-----.||.----.-----.|",
                        "|o|  |.|   |.||.|  |.|   |o|",
                        "|.----.-----.||.----.-----.|",
                        "|..........................|",
                        "|.----.--.--------.--.----.|",
                        "|.----.||.---||---.||.----.|",
                        "|......||....||....||......|",
                        "|-----.||--| || |--||.-----|",
                        "     |.||--| -- |--||.|     ",
                        "     |.||     F    ||.|     ",
                        "     |.|| -------- ||.|     ",
                        "-----|.|| |   F  | ||.|-----",
                        "      .   |   F  |   .      ",
                        "-----|.|| |   F  | ||.|-----",
                        "     |.|| -------- ||.|     ",
                        "     |.||          ||.|     ",
                        "     |.|| -------- ||.|     ",
                        "-----|.|| -------- ||.|-----",
                        "|............||............|",
                        "|.----.-----.||.-----.----.|",
                        "|.----.-----.||.-----.----.|",
                        "|o..||.......P........||..o|",
                        "|--.||.||.--------.||.||.--|",
                        "|--.||.||.--------.||.||.--|",
                        "|......||....||....||......|",
                        "|.----------.||.----------.|",
                        "|.----------.||.----------.|",
                        "|..........................|",
                        "|--------------------------|"
                };

        n = terrainOriginal.length;
        m = terrainOriginal[0].length();

        terrain = new Tuile[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char caractere = terrainOriginal[i].charAt(j);
                terrain[i][j] = new Tuile(caractere);
                if (caractere == Pacman.CARACTERE_PACMAN) {
                    pacman = new Pacman(new Position(i, j), this);
                }
            }
        }

        changement = true;
    }

    public void afficher() {
        if (!changement)
            return;

        changement = false;

        StringBuilder affichage = new StringBuilder(ANSI_NETTOYAGE);
        affichage.append("Nombre pieces = " + pacman.getNombrePieces() + '\n');
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                affichage.append(terrain[i][j].affichage());
            }
            affichage.append('\n');
        }

        System.out.println(affichage);
    }

    public boolean deplacementPossible(Position pos) {
        if (pos.i < 0 || pos.i >= n || pos.j < 0 || pos.j >= m)
            return false;

        Tuile tuile = terrain[pos.i][pos.j];
        return tuile.estTraversable();
    }

    public void entrerSurTuile(Position pos, Personnage personnage) {
        Tuile tuile = terrain[pos.i][pos.j];
        tuile.personnageEntreSurTuile(personnage);

        changement = true;
    }

    public void quitterTuile(Position pos, Personnage personnage) {
        Tuile tuile = terrain[pos.i][pos.j];
        tuile.personnageQuitteTuile(personnage);
    }

    public Pacman getPacman() {
        return pacman;
    }
}
