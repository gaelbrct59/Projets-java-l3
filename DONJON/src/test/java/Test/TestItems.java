/**
 * 
 */
package Test;


import org.junit.jupiter.api.Test;



import static org.junit.Assert.assertEquals;

import Game_Dungeon.AdventureGame;
import Game_Dungeon.Item;
import Game_Dungeon.Room;
import entities.Player;

/**
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public abstract class TestItems {

	protected abstract Item createItem();

	protected Item myItem = this.createItem();
	protected Room room = new Room();
	private Player p = new Player(0, 0, 0);

	protected AdventureGame game = new AdventureGame(room);

	protected abstract int getItemsGetter(Player p);

	@Test
	void testListItemInTheRoomIsUsed() {
		this.room.addItem(this.myItem);
		assertEquals(1, this.room.getItems().size());
	}

	@Test
	void testIsUsedBy() {

		p.addToGame(this.game);
		this.room.addItem(this.myItem);
		this.myItem.isUsedBy(p);
		assertEquals(5, this.getItemsGetter(p));
	}

}
