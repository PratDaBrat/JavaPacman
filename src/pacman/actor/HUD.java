package pacman.actor;

import pacman.PacmanActor;
import pacman.PacmanGame;
import pacman.PacmanGame.State;
import java.awt.Graphics2D;

/**
 * HUD class.
 * 
 * @author pc
 */
public class HUD extends PacmanActor {

    public HUD(PacmanGame game) {
        super(game);
    }

    @Override
    public void init() {
        loadFrames("/images/pacman_life.png");    
    }

    @Override
    public void draw(Graphics2D g) {
        if (!visible) {
            return;
        }
        game.drawText(g, "SCORE", 10, 1);
        game.drawText(g, game.getScore(), 10, 10);
        game.drawText(g, "HIGH SCORE ", 78, 1);
        game.drawText(g, game.getHiscore(), 90, 10);
        game.drawText(g, "LIVES: ", 10, 274);
        for (int lives = 0; lives < game.lives; lives++) {
            g.drawImage(frame, 60 + 20 * lives, 272, null);
        }
    }

    // broadcast messages
    
    @Override
    public void stateChanged() {
        visible = (game.state != State.INITIALIZING)
                && (game.state !=State.Praty_PRESENTS);
    }
    
}
