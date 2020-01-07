package Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import Game_Dungeon.AdventureGame;
import Game_Dungeon.Room;
import entities.*;

/**
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public class TestCharacter {

	Player p = new Player(20, 20, 20);
	Monster m = new Monster(100, 5, 5);
	Room room = new Room();
	AdventureGame game = new AdventureGame(room);

	@Test
	void testPlayersGetter() {
		assertEquals(20, p.getLife());
		assertEquals(100, m.getLife());
	}

	@Test
	void testAttackMonsterLoseHP() {
		p.attack(m);
		assertEquals(80, m.getLife());
	}

	@Test
	void testIsDead() {
		p.setStrenght(99);
		p.attack(m);
		assertEquals(1, m.getLife());
		assertFalse(m.isDead());
		p.attack(m);
		assertTrue(m.isDead());
	}

	@Test
	void testMonstersDieDropGoldPurse() {

		game.addMonster(m, room);

		assertFalse(game.getCurrentRoom().getItems().size() > 0);
		m.Die();
		assertTrue(game.getCurrentRoom().getItems().size() > 0);
	}

	@Test
	void testMonstersDieRemoveTheMonsterFromTheRoom() {
		game.addMonster(m, room);
		assertTrue(this.game.getCurrentRoom().getMonster().size() == 1);
		m.Die();
		assertTrue(game.getCurrentRoom().getMonster().size() == 0);
	}

}
