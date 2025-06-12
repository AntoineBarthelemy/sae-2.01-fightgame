package miscellaneous;

import afficheur.SpritesHeros;
import java.awt.Graphics;
import java.awt.Color;
import java.io.IOException;
import afficheur.Repere;
import physique.ObjetHeros;

public class HeroCarreQuandTouche2 extends ObjetHeros {

    private boolean enAttaque = false;
    private boolean enAttaquePied = false;
    private long debutAttaque = 0;
    private long debutAttaquePied = 0;

    private final int dureeAttaque = 200;

    public HeroCarreQuandTouche2() throws IOException {
        sprites = new SpritesHeros(this, "sprites/Ryu");

        height = sprites.sprites.get("fixe").ty;
        width = sprites.sprites.get("fixe").tx;
        vx = -1;
        vy = 3;
        ax = 0;
        ay = -0.04;
    }

    public void changeEtape(String nouvelleActivite) {
        enAttaque = nouvelleActivite.equals("attaque");
        debutAttaque = System.currentTimeMillis();
    }

    public void changeEtapePied(String nouvelleActivite) {
        enAttaquePied = nouvelleActivite.equals("attaque-pied");
        debutAttaquePied = System.currentTimeMillis();
    }

    public void declencherAttaque() {
        enAttaque = true;
        debutAttaque = System.currentTimeMillis();
        ((SpritesHeros) sprites).resetAttaque();
        changeEtape("attaque");
    }

    public void declencherAttaquePied() {
        enAttaquePied = true;
        debutAttaquePied = System.currentTimeMillis();
        ((SpritesHeros) sprites).resetAttaquePied();
        changeEtape("attaque-pied");

    }

    private int num = 0;

    public void attaquer() {
        declencherAttaque();
        changeEtape("attaque");
    }

    public void attaquerPied() {
        enAttaquePied = true;
        debutAttaquePied = System.currentTimeMillis();
        ((SpritesHeros) sprites).resetAttaquePied();
        changeEtape("attaque-pied");
    }

}
