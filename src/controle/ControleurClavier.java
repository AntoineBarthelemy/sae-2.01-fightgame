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

package controle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//permet de faire un controleur de clavier

/**
 *
 * @author Pierre-Frederic Villard
 */
public class ControleurClavier implements KeyListener {

	// fin du jeu

	/**
	 *
	 */
	public static boolean fin = false;

	// afficheur
	boolean affiche = false;
	AfficheControle afficheur;

	// la variable de controle

	/**
	 *
	 */
	public Controle c1;

	// constructeur avec affichage du controleur ou non.

	/**
	 *
	 * @param affiche
	 */
	public ControleurClavier(boolean affiche) {
		c1 = new Controle();
		this.affiche = affiche;
		if (affiche)
			afficheur = new AfficheControle(c1);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// vide
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// touche gauche
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			c1.gauche = true;
		}
		// touche droite
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			c1.droite = true;
		}
		// touche up
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			c1.haut = true;
		}
		// touche down
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			c1.bas = true;
		}
		// touche up
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			fin = true;
		}

		if (affiche)
			afficheur.dessin();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// touche gauche
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			c1.gauche = false;
		}
		// touche droite
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			c1.droite = false;
		}
		// touche up
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			c1.haut = false;
		}
		// touche down
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			c1.bas = false;
		}
		if (affiche)
			afficheur.dessin();

	}

}
