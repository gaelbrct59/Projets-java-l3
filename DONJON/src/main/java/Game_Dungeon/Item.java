package Game_Dungeon;

import entities.Player;

/** Items available, if it's possible, and execute
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public interface Item {
	/**
	 * The item is used by the player (collect and use)
	 * 
	 * @param p : Player
	 */
	void isUsedBy(Player p);

	String toString();

}
