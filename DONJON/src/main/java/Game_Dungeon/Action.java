package Game_Dungeon;

import entities.Player;

/** What the player can do
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public abstract class Action {

	public abstract boolean canPerform(Player p);

	public abstract void perform(Player p);

}
