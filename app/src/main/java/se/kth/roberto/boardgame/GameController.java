package se.kth.roberto.boardgame;

/**
 * Created by guancio on 08/11/2017.
 */

public class GameController {
    GameModel gameInstance;

    public GameController() {
        gameInstance = new GameModel();
    }

    public void resetGame() {
        this.gameInstance.playerPositionX = 0;
    }

    public void goLeft() {
        if (this.gameInstance.playerPositionX <= 0)
            return;
        this.gameInstance.playerPositionX -= 1;
    }
    public void Right() {
        if (this.gameInstance.playerPositionX >= 7)
            return;
        this.gameInstance.playerPositionX += 1;
    }
    public boolean winCondition() {
        return (this.gameInstance.playerPositionX == 7);
    }
}
