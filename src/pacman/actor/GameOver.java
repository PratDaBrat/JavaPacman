package pacman.actor;


import pacman.PacmanActor;
import pacman.PacmanGame.State;
import pacman.PacmanGame;
/**
 * GameOver class.
 * 
 * @author pc
 */
public class GameOver extends PacmanActor {
    
    public GameOver(PacmanGame game) {
        super(game);
    }

    @Override
    public void init() {
        x = 77;
        y = 160;
        loadFrames("/images/gameover.png"); //pacman/gam
    }
    
    @Override
    public void updateGameOver() {
        yield://label
        while (true) {
            switch (instructionPointer) {
                case 0:
                    waitTime = System.currentTimeMillis();
                    instructionPointer = 1;
                case 1:
                    if (System.currentTimeMillis() - waitTime < 3000) {
                        break yield;
                    }
                    game.returnToTitle();
                    break yield;
            }
        }
    }

    // broadcast messages
    
    @Override
    public void stateChanged() {
        visible = false;
        if (game.state == State.GAME_OVER) {
            visible = true;
            instructionPointer = 0;
        }
    }
        
}
