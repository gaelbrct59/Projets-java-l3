package Test_TheItems;

import Test.TestItems;
import entities.Player;
import item.GoldPurse;

import Game_Dungeon.Item;

/**
 * @author BRICOUT Gael & BEAREZ Antoine
 *
 */
class TestGoldPurse extends TestItems {

	@Override
	protected Item createItem() {
		return new GoldPurse(5);
	}

	@Override
	protected int getItemsGetter(Player p) {
		return p.getGold();
	}

}
