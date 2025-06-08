package miscellaneous;

import afficheur.SpritesHeros;
import java.awt.Graphics;
import java.awt.Color;
import java.io.IOException;
import afficheur.Repere;
import physique.ObjetHeros;

public class HeroCarreQuandTouche2 extends ObjetHeros {

    private boolean enAttaque = false;
    private long debutAttaque = 0;
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

    public void declencherAttaque() {
        enAttaque = true;
        debutAttaque = System.currentTimeMillis();
        ((SpritesHeros) sprites).resetAttaque();
        changeEtape("attaque");
    }

    private int num = 0;

    public void attaquer() {
        declencherAttaque();
        changeEtape("attaque");
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.black);
        int[] tab = Repere.changeRepere(this);

        if (enAttaque) {
            long tempsEcoule = System.currentTimeMillis() - debutAttaque;
            if (tempsEcoule < dureeAttaque) {
                num++;
                ((SpritesHeros) sprites).afficherAttaque(g, tab[0], tab[1], tab[2], tab[3]);
            } else {
                enAttaque = false;
                num = 0;
            }
        } else {
            sprites.affiche(tab[0], tab[1], g);
            sprites.anime();
        }
    }
}
