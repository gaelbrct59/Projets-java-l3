package Test_TheItems;

import Game_Dungeon.Item;
import Test.TestItems;
import entities.Player;
import item.StrengthPotion;

/**
 * @author BRICOUT Gael & BEAREZ Antoine
 *
 */
class TestStrengthPotion extends TestItems {

	@Override
	protected Item createItem() {
		return new StrengthPotion(5);
	}

	@Override
	protected int getItemsGetter(Player p) {
		return p.getStrenght();
	}

}
