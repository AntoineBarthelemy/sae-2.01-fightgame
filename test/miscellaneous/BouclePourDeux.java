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

import controle.ControleurClavier;
import main.BouclePrincipale;
import main.JeuPhysique;



/**
 *
 * @author Pierre-Frederic Villard
 */
public class BouclePourDeux extends BouclePrincipale{
    
    public ControleurClavier2 cClavier2;
    
    public BouclePourDeux() throws Exception{
        //creation du jeu
        //jeuPhysique = new JeuPhysique();
        //jeuPhysique.moteurPhys=
    }
        
         @Override
    public void lanceBouclePrincipale() throws Exception {
		

		//ControleurClavier cClavier=new ControleurClavier(true);
		jeuPhysique.affiche.addKeyListener(cClavier);
                jeuPhysique.affiche.addKeyListener(cClavier2);
		//mettre l'acces au controleur dans monde

		jeuPhysique.moteurPhys.monde.c=cClavier.c;
                MondePourDeux monMonde=(MondePourDeux) jeuPhysique.moteurPhys.monde;
                monMonde.c2=cClavier2.c;

		//afficher
		System.out.println("\n\n**************************************************");
		System.out.println("*  "+nom);
		System.out.println("*                                                 *");
		System.out.println("*** touche 'Q' pour arreter jeu                  ***");
		System.out.println("****************************************************");
		System.out.println("\n\n");
		
		//fps
		long dureeBoucle=1000000/fps;
		System.out.println(" ---> duree d'une boucle "+dureeBoucle/1000.);		
		
		//lancement
		Thread.sleep(1000);
		jeuPhysique.affiche.requestFocusInWindow();
		
		// boucle
		long beforeTime = System.nanoTime();
		long l = System.currentTimeMillis();
		//nombre iterations
		int n=0;
		while(!ControleurClavier.fin)
		{	
			n++;
			jeuPhysique.update();
			jeuPhysique.render();
			
                        switch (jeuPhysique.moteurPhys.monde.balle.collision)
                        {

                        }
                        
                        
			//apres le render en nanos
			long timafter=System.nanoTime();
				
			//sleep en millisecond
			while(System.nanoTime()-beforeTime-dureeBoucle*1000L<0)
				{
				}
			beforeTime=System.nanoTime();
						
		}
		long l2 = System.currentTimeMillis();


		// statistiques
		System.out.println("\n\n\n************************\n");
		System.out.println("Iterations = "+n);
		System.out.println("FPS = " + (n * 1000.0 / (l2 - l)));
		System.out.println("\n************************");

		
		System.exit(0);
	}

    
}
