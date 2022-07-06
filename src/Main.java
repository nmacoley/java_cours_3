public class Main {
    public static void main(String[] args) throws InterruptedException {
        GestionnaireTouches gestionTouches = GestionnaireTouches.getGestionnaireTouches();
        Terrain terrain = new Terrain();
        Pacman pacman = terrain.getPacman();

        final long MAIN_LOOP_TIME = 5L;
        while (true) {
            int touche = gestionTouches.recupererTouche();
            pacman.deplacer(touche);

            terrain.afficher();
            Thread.sleep(MAIN_LOOP_TIME);
        }
    }
}
