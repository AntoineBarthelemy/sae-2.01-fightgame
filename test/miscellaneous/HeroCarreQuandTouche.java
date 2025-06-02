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
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import physique.ObjetHeros;

/**
 *
 * @author Pierre-Frederic Villard
 */
public class HeroCarreQuandTouche extends ObjetHeros{
    
        /**
     *
     * @throws IOException
     */
	public HeroCarreQuandTouche() throws IOException
	{
		
	
		
		sprites=new SpritesHeros(this);
		height=10;
		width=10;
		height=sprites.sprites.get("fixe").ty;
		width=sprites.sprites.get("fixe").tx;
		vx=1;
		vy=3;
		ax=0;
		ay=-0.04;
	}
    /**
     * 
     * 
     */
        @Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		
		//change de repere
		int[]tab=Repere.changeRepere(this);
		sprites.affiche(tab[0],tab[1],g);
		sprites.anime();
		
		// si en collision affiche carre
		if (collision==1) {
			g.setColor(Color.red);
			g.fillRect(tab[0],tab[1],tab[2],tab[3]);
		}
	}
}
