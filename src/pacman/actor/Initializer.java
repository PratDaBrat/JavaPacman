package pacman.actor;

import pacman.PacmanActor;
import pacman.PacmanGame;
import pacman.PacmanGame.State;

/**
 * Initializer class.
 * 
 * @author pc
 */
public class Initializer extends PacmanActor {

    public Initializer(PacmanGame game) {
        super(game);
    }

    @Override
    public void updateInitializing() {
        yield:
        while (true) {
            switch (instructionPointer) {
                case 0:
                    waitTime = System.currentTimeMillis();
                    instructionPointer = 1;
                case 1:
                    if (System.currentTimeMillis() - waitTime < 3000) {
                        break yield;
                    }
                    instructionPointer = 2;
                case 2:
                    game.setState(State.Praty_PRESENTS);
                    break yield;
            }
        }
    }
    
}
