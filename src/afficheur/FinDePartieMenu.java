package afficheur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinDePartieMenu extends JFrame {
    public FinDePartieMenu() {
        setTitle("Fin de Partie");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Le combat est terminé !");
        add(label);

        JButton rejouer = new JButton("Rejouer");
        JButton quitter = new JButton("Quitter");

        // Bouton Rejouer
        rejouer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Ferme le menu
                System.out.println("Arrêt propre du jeu avant redémarrage...");

                try {
                    // Pause pour s'assurer que la boucle s'est bien stoppée
                    Thread.sleep(1000);

                    // Redémarrer un nouveau processus proprement
                    String javaCommand = "java -cp " + System.getProperty("java.class.path") + " testFighter";
                    Runtime.getRuntime().exec(javaCommand);
                } catch (Exception ex) {
                    System.out.println("Erreur lors du redémarrage !");
                    ex.printStackTrace();
                }
            }
        });

        // Bouton Quitter
        quitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(rejouer);
        add(quitter);
    }

    // Afficher le menu de fin de partie
    public static void afficherMenu() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FinDePartieMenu().setVisible(true);
            }
        });
    }
}
