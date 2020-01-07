/**
 * 
 */
package Test_TheActions;

import Game_Dungeon.Action;
import Game_Dungeon.Direction;
import Game_Dungeon.Room;
import Test.TestAction;
import action.Move;

/**
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
class TestMove extends TestAction {
//	private Action a = new Move();

	// There is no monster, so the player can move
	@Override
	protected void effectCanPerformDependToAction() {
	}

	@Override
	protected Action createAction() {
		return new Move();
	}

	@Override
	protected boolean effectCorrectlyAccomplished() {
		Room newRoom = room;
		Room oldRoom = new Room();
		room.addNeighbors(Direction.EAST, oldRoom);
		//a.perform(p);
		newRoom = p.getGame().getCurrentRoom();
		// Check if the player has changed of room
		return !oldRoom.equals(newRoom);
	}

}
