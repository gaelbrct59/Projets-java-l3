/**
 * 
 */
package Test_TheActions;

import Game_Dungeon.Action;
import Test.TestAction;
import action.Look;

/**
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
class TestLook extends TestAction {

//	private Action a = new Look();

	@Override
	protected Action createAction() {
		return new Look();
	}

	@Override
	protected void effectCanPerformDependToAction() {
	}

	@Override
	protected boolean effectCorrectlyAccomplished() {
		return true; // TODO
	}

}
