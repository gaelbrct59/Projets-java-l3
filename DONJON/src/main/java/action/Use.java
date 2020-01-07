package action;

import Game_Dungeon.Action;
import Game_Dungeon.Item;
import entities.Player;
import util.Chooser;

/** Use and collect an chosen item
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public class Use extends Action {

	@Override
	public boolean canPerform(Player p) {
		return !(p.getGame().getCurrentRoom().getItems().isEmpty());
	}

	@Override
	public void perform(Player p) {
		// Choose what Item Player want to consume
		Item i = Chooser.choose(p.getGame().getCurrentRoom().getItems(), "Choose an item and use it");
		i.isUsedBy(p);
	}

	@Override
	public String toString() {
		return "Collect and use the item";
	}

}
