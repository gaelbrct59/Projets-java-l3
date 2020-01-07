package Game_Dungeon;

/** All the directions available
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public enum Direction {
	NORTH, EAST, WEST, SOUTH;

	Direction() {
	}

	/**
	 * Get the opposite of the actual room.
	 * 
	 * @return Direction
	 */
	public Direction opposite() {

		if (this.equals(Direction.EAST)) {
			return Direction.WEST;
		} else if (this.equals(Direction.NORTH)) {
			return Direction.SOUTH;
		} else if (this.equals(Direction.WEST)) {
			return Direction.EAST;
		} else {
			return Direction.NORTH;
		}
	}

}
