package Test_TheItems;

import Game_Dungeon.Item;
import Test.TestItems;
import entities.Player;
import item.LifePotion;

/**
 * @author BRICOUT Gael & BEAREZ Antoine
 *
 */
class TestLifePotion extends TestItems {

	@Override
	protected Item createItem() {
		return new LifePotion(5);
	}

	@Override
	protected int getItemsGetter(Player p) {
		return p.getLife();
	}

}
