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

import controle.AfficheControle;
import controle.Controle;
import controle.ControleurClavier;
import static controle.ControleurClavier.fin;
import java.awt.event.KeyEvent;

/**
 *
 * @author Pierre-Frederic Villard
 */
public class ControleurClavier2 extends ControleurClavier{

    public ControleurClavier2(boolean affiche) {
        super(affiche);
    }

    /**
     *
     * @param affiche
     */      
    @Override
	public void keyPressed(KeyEvent e) {
		//touche gauche
		if (e.getKeyCode()==KeyEvent.VK_A)
		{
			c.gauche=true;			
		}
		//touche droite
		if (e.getKeyCode()==KeyEvent.VK_E)
		{
			c.droite=true;
		}
		//touche up
		if (e.getKeyCode()==KeyEvent.VK_Z)
		{
			c.haut=true;
		}
		//touche down
		if (e.getKeyCode()==KeyEvent.VK_S)
		{
			c.bas=true;
		}		
		//touche up
		if (e.getKeyCode()==KeyEvent.VK_Q)
		{
			fin=true;
		}

		// attaque
		if (e.getKeyCode()==KeyEvent.VK_T){
			c.attaque = true;


		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//touche gauche
		if (e.getKeyCode()==KeyEvent.VK_A)
		{
			c.gauche=false;
		}
		//touche droite
		if (e.getKeyCode()==KeyEvent.VK_E)
		{
			c.droite=false;
		}
		//touche up
		if (e.getKeyCode()==KeyEvent.VK_Z)
		{
			c.haut=false;
		}
                //touche down
		if (e.getKeyCode()==KeyEvent.VK_S)
		{
			c.bas=false;
		}

		if (e.getKeyCode()==KeyEvent.VK_T) c.attaque = false;
	}
	
}
