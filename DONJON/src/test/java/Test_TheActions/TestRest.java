/**
 * Test Actions's Rest
 */
package Test_TheActions;

import Game_Dungeon.Action;
import Test.TestAction;
import action.Rest;

/**
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
class TestRest extends TestAction{


	@Override
	protected Action createAction() {
		return new Rest();
	}

	@Override
	// No monster in the room = nothing to do
	protected void effectCanPerformDependToAction() {}

	@Override
	protected boolean effectCorrectlyAccomplished() {
		int life = p.getLife();
		//a.perform(p);
		return p.getLife() == life + Rest.LIFE_WON_WITH_REST;
	}

	

}
