/**
 * 
 */
package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Game_Dungeon.AdventureGame;
import Game_Dungeon.AlreadyDeadException;
import Game_Dungeon.Item;
import Game_Dungeon.Room;
import entities.Monster;
import entities.Player;
import item.GoldPurse;

/**
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
class TestAdventureGame {

	Room room = new Room();
	AdventureGame game = new AdventureGame(room);

	@Test
	void testAddMonster() {
		Monster m = new Monster(5, 5, 5);
		game.addMonster(m, room);
		assertEquals(game.getCurrentRoom().getMonster().get(0), m);
	}

	@Test
	void testCreateMonstersInTheRoom() {
		game.createMonstersInTheRoom();
		assertFalse(game.getCurrentRoom().getMonster().isEmpty());
	}

	@Test
	void testAddItem() {
		Item i = new GoldPurse(57);
		game.addItem(i, room);
		assertEquals(i, game.getCurrentRoom().getItems().get(0));
	}

	@Test
	void testPlayDontWorkWithAlreadyDeadPlayer() {
		Player p = new Player(0, 0, 0);
		Assertions.assertThrows(AlreadyDeadException.class, () -> game.play(p));
	}

	@Test
	void testAddAction() {
		assertTrue(game.getActions().size() > 1);
	}

}
