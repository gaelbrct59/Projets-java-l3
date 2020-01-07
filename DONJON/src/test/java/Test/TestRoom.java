package Test;



import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Game_Dungeon.*;
import entities.Monster;
import item.GoldPurse;

/**
 * @author BRICOUT Gael & BEAREZ Antoine
 *
 */
class TestRoom {

	// Global
	Room room = new Room();

	@Test
	void testAddRoom() {
		room.addMonster(new Monster(5, 5, 5));
		room.addItem(new GoldPurse(50));
		
		assertEquals(1,room.getMonster().size());
		assertEquals(1,room.getItems().size());
	}

	@Test
	void testRemoveMonstersReturnIsEmpty() {
		Monster m = new Monster(5, 5, 5);
		room.addMonster(m);
		assertFalse(room.getMonster().isEmpty());
		room.removeMonster(m);
		assertTrue(room.getMonster().isEmpty());
	}

	@Test
	void testRemoveItemsReturnIsEmpty() {
		Item i = new GoldPurse(5);
		room.addItem(i);
		assertFalse(room.getItems().isEmpty());
		room.removeItem(i);
		assertTrue(room.getItems().isEmpty());
	}


	@Test
	void testCreateItemsInTheRoom() {
		AdventureGame game=new AdventureGame(room);
		game.getCurrentRoom().createItemsInTheRoom();
		assertFalse(room.getItems().isEmpty());
	}


}
