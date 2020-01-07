/**
 * 
 */
package Test;


import org.junit.jupiter.api.Test;



import static org.junit.Assert.assertTrue;

import Game_Dungeon.Action;
import Game_Dungeon.AdventureGame;
import Game_Dungeon.Room;
import entities.Monster;
import entities.Player;

/** 
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public abstract class TestAction {
	protected abstract Action createAction();

	protected Action a = createAction();

	protected Room room = new Room();
	protected AdventureGame game = new AdventureGame(room);
	protected Player p = new Player(20, 4, 0);
	protected Monster m = new Monster(5, 5, 5);

	protected abstract void effectCanPerformDependToAction();

	@Test
	void testCanPerform() {
		p.addToGame(game);
		effectCanPerformDependToAction();
		assertTrue(a.canPerform(p));
	}

	protected abstract boolean effectCorrectlyAccomplished();

	/*
	@Test
	void testPerform() {
		p.addToGame(game);
		assertTrue(effectCorrectlyAccomplished());
	}*/

}
