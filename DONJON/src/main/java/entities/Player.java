/**
 * 
 */
package entities;

import java.util.ArrayList;
import java.util.List;

import Game_Dungeon.Action;
import Game_Dungeon.Character;
import util.Chooser;

/** The game's player
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public class Player extends Character {

	public Player(int LifePoints, int strenght, int gold) {
		super(LifePoints, strenght, gold);
	}

	@Override
	/**
	 * Die of the character... Game over for player or one monster beaten.
	 * 
	 */
	public void Die() {
		System.out.println("GAME OVER : You die... The monster was better than u");
	}

	/**
	 * Get the Available actions for the actual player
	 * 
	 * @return Action
	 */
	private List<Action> possibleActions() {
		List<Action> availableActions = new ArrayList<Action>();

		for (Action a : this.getGame().getActions()) {
			if (a.canPerform(this)) {
				availableActions.add(a);
			}
		}

		return availableActions;
	}

	/**
	 * Attack the foe c
	 * 
	 */

	public void attack(Character c) {
		c.setLife(c.getLife() - this.getStrenght());

	}

	/**
	 * The player choose the available action
	 */
	public void act() {

		Action a = Chooser.choose(this.possibleActions(), "Choose an action :");
		a.perform(this);

	}

	@Override
	public String toString() {
		return "You have " + this.getLife() + " HP, " + this.getGold() + " GOLD and " + this.getStrenght()
				+ " STRENGHT";
	}

}
