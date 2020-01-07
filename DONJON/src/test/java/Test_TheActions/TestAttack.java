/**
 * 
 */
package Test_TheActions;

import Game_Dungeon.Action;
import Test.TestAction;
import action.Attack;

/**
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
class TestAttack extends TestAction {
//	private Action a = new Attack();

	@Override
	protected Action createAction() {
		return new Attack();
	}

	private void addMonsterToTheRoom() {
		game.addMonster(m, room);
	}

	@Override
	protected void effectCanPerformDependToAction() {
		addMonsterToTheRoom();
	}

	@Override
	/**
	 * the player correctly attack the monster
	 */
	protected boolean effectCorrectlyAccomplished() {
		addMonsterToTheRoom();
		//a.perform(p);
		return m.getLife() == 1;
	}

}
