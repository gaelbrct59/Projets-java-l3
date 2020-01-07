/**
 * 
 */
package Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Game_Dungeon.Direction;

/**
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
class TestDirection {

	@Test
	void testOpposite() {
		assertEquals(Direction.EAST, Direction.WEST.opposite());
	}

}
