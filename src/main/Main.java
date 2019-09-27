package main;

import pacman.PacmanGame;
import pacman.infra.Display;
import pacman.infra.Game;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


/**
 * Main class.
 * 
 * @author pc
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Game game = new PacmanGame();
                Display view = new Display(game);
                JFrame frame = new JFrame();
                frame.setTitle("Pacman");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(view);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                view.requestFocus();
                view.start();
            }

        });
    }
    
}
