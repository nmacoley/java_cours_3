import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;

import static java.awt.event.KeyEvent.*;

public final class GestionnaireTouches extends JFrame implements KeyListener {
    private static final Set<Integer> touchesDeDeplacement = Set.of(new Integer[]{
        VK_UP,
        VK_LEFT,
        VK_DOWN,
        VK_RIGHT
    });
    private static GestionnaireTouches gestionnaireTouches;
    boolean touchePressee;
    int touche;
    public GestionnaireTouches() {
        if (gestionnaireTouches != null) {
            System.err.println("Attention, création d'un second gestionnaire de touches !");
            System.exit(1);
        }
        gestionnaireTouches = this;

        // On enregistre notre fenêtre JFrame comme "écouteur" d'évènements de touches, et on l'affiche
        // L'interface KeyListener nous oblige à définir keyPressed, keyReleased et keyTyped
        addKeyListener(this);
        setVisible(true);
    }

    public static GestionnaireTouches getGestionnaireTouches() {
        if (gestionnaireTouches == null) {
            gestionnaireTouches = new GestionnaireTouches();
        }
        return gestionnaireTouches;
    }

    @Override
    public void keyPressed(KeyEvent ke){
        touchePressee = true;
        touche = ke.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent ke){
        if (touche == ke.getKeyCode())
            touchePressee = false;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    public int recupererTouche() {
        if (!touchePressee)
            return -1;

        if (!touchesDeDeplacement.contains(touche))
            return -1;

        return touche;
    }
}