/**
 * 
 */
package Test_TheActions;

import Game_Dungeon.Action;
import Game_Dungeon.Item;
import Test.TestAction;
import action.Use;
import item.GoldPurse;

/**
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
class TestUse extends TestAction {
//	private Action a = new Use();

	@Override
	protected Action createAction() {
		return new Use();
	}

	private void addItemInTheRoom() {
		Item i = new GoldPurse(5);
		game.addItem(i, room);
	}

	@Override
	protected void effectCanPerformDependToAction() {
		addItemInTheRoom();
	}

	@Override
	/**
	 * Player win 5 gold and the item is correctly delete
	 */
	protected boolean effectCorrectlyAccomplished() {
		addItemInTheRoom();
		//a.perform(p);
		return p.getGold() == 5 && room.getItems().size() == 0;
	}

}
