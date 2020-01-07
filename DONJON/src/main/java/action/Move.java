/**
 * 
 */
package action;

import Game_Dungeon.Action;
import entities.Player;
import util.Chooser;

/** Change of Room
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public class Move extends Action {

	@Override
	public boolean canPerform(Player p) {
		// Return true if there isn't other monster in the room, so the player can move
		return p.getGame().getCurrentRoom().getMonster().isEmpty();
	}

	@Override
	public void perform(Player p) {
		p.getGame().playerMoveTo(
				Chooser.choose(p.getGame().getCurrentRoom().getNeighborDirections(), "Choose a direction"));
		System.out.println("You've just changed of room");

	}

	@Override
	public String toString() {
		return "Move to the next Room";
	}

}
