/**
 * 
 */
package action;

import Game_Dungeon.Action;
import entities.Player;

/** Get life back
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public class Rest extends Action{

	public static final int LIFE_WON_WITH_REST = 3;
	@Override
	public boolean canPerform(Player p) {
		return p.getGame().getCurrentRoom().getMonster().isEmpty();
	}

	@Override
	public void perform(Player p) {
		p.setLife(p.getLife() + LIFE_WON_WITH_REST);
	}
	public String toString() {
		return "Rest a moment, for get life back";
	}

}
