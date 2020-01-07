/**
 * 
 */
package Game_Dungeon;

/** If the player who's add to game has less than 0 HP
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
@SuppressWarnings("serial")
public class AlreadyDeadException extends Exception {
	public AlreadyDeadException(String msg) {
		super(msg);
	}
}
