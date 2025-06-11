/* ========================================================== */
/*                  Bibliotheque MoteurDeJeu                  */
/* --------------------------------------------               */
/* Bibliotheque pour aider la création de jeu video comme :   */
/* - Jeux de role                                             */
/* - Jeux de plateforme                                       */
/* - Jeux de combat                                           */
/* - Jeux de course                                           */
/* - Ancien jeu d'arcade (Pac-Man, Space Invider, Snake, ...) */
/* ========================================================== */
package miscellaneous;

import afficheur.Repere;
import afficheur.SpritesHeros;
import controle.Controle;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import physique.ObjetHeros;

/**
 *
 * @author Pierre-Frederic Villard
 */
public class HeroCarreQuandTouche extends ObjetHeros {

	/**
	 *
	 * @throws IOException
	 */

	private boolean enAttaque = false;
	private boolean enAttaquePied = false;
	private long debutAttaque = 0;
	private long debutAttaquePied = 0;
	private final int dureeAttaque = 200; // en millisecondes

	public HeroCarreQuandTouche() throws IOException {

		sprites = new SpritesHeros(this, "sprites/Ken");
		height = sprites.sprites.get("fixe").ty;
		width = sprites.sprites.get("fixe").tx;
		vx = 1;
		vy = 3;
		ax = 0;
		ay = -0.04;
	}

	public void changeEtape(String nouvelleActivite) {
		enAttaque = nouvelleActivite.equals("attaque");
		debutAttaque = System.currentTimeMillis(); // Démarre l'attaque si activée
		enAttaquePied = nouvelleActivite.equals("attaque-pied");
		debutAttaquePied = System.currentTimeMillis();
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

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		int[] tab = Repere.changeRepere(this);

		// Gestion du coup de poing
		if (enAttaque) {
			long tempsEcoule = System.currentTimeMillis() - debutAttaque;
			if (tempsEcoule < dureeAttaque) {
				num++;
				((SpritesHeros) sprites).afficherAttaque(g, tab[0], tab[1], tab[2], tab[3]);
			} else {
				enAttaque = false;
				num = 0;
			}
		}

		// Gestion du coup de pied
		else if (enAttaquePied) {
			long tempsEcoule = System.currentTimeMillis() - debutAttaquePied;
			if (tempsEcoule < dureeAttaque) {
				num++;
				((SpritesHeros) sprites).afficherAttaquePied(g, tab[0], tab[1], tab[2], tab[3]);
			} else {
				enAttaquePied = false;
				num = 0;
			}
		}

		// Animation normale quand il n'attaque pas
		else {
			sprites.affiche(tab[0], tab[1], g);
			sprites.anime();
		}
	}

}
