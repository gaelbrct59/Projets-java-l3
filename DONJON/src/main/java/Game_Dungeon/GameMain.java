/**
 * 
 */
package Game_Dungeon;

import java.util.ArrayList;
import entities.Player;
import util.Chooser;

/** MAIN
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public class GameMain {

	public static void main(String[] args) throws AlreadyDeadException {
		System.out.println("Play to the game");
		Player p = new Player(40, 6, 0);

		// Method extract
		AdventureGame game = initGameWithStartingRoom(p);
		theFirstMoveOfTheStartingRoom(game);
		game.play(p);
	}

	/**
	 * Init game
	 * 
	 * @param p
	 * @return game
	 */
	private static AdventureGame initGameWithStartingRoom(Player p) {
		Room startingRoom = new Room();
		AdventureGame game = new AdventureGame(startingRoom); // actions initialisees
		p.addToGame(game);
		return game;
	}

	/**
	 * Manages the first move of the game (no monster/item)
	 * 
	 * @param game
	 */
	private static void theFirstMoveOfTheStartingRoom(AdventureGame game) {
		ArrayList<Direction> chooseFirstDirection = new ArrayList<Direction>();
		chooseFirstDirection.add(Direction.WEST);
		chooseFirstDirection.add(Direction.NORTH);
		chooseFirstDirection.add(Direction.EAST);
		game.playerMoveTo(Chooser.choose(chooseFirstDirection, "Choose the first Direction"));
	}

}
