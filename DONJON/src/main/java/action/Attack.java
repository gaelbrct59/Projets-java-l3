/**
 * 
 */
package action;

import Game_Dungeon.Action;
import entities.Monster;
import entities.Player;
import util.Chooser;

/** Attack the monster. Monster hit back
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public class Attack extends Action {

	@Override
	public boolean canPerform(Player p) {
		return !(p.getGame().getCurrentRoom().getMonster().isEmpty());
	}

	@Override
	public void perform(Player p) {
		Monster monster = Chooser.choose(p.getGame().getCurrentRoom().getMonster(), "Choose the monster to attack");
		p.attack(monster);
		if (!monster.isDead()) {
			System.out.println("The monster hit you back ! -" + monster.getStrenght() + " HP");
			monster.attack(p);

		} else {
			monster.Die();
		}
	}

	@Override
	public String toString() {
		return "Attack a monster";
	}

}
