/**
 * 
 */
package entities;

import Game_Dungeon.Character;
import Game_Dungeon.Item;
import item.GoldPurse;
import util.RandomThings;

/** A monster with a name, life, strength and gold
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public class Monster extends Character {
	private String name;

	public Monster(int LifePoints, int strenght, int gold) {
		super(LifePoints, strenght, gold);
		this.name = RandomThings.randomNameMonster();
	}

	public Monster(int LifePoints, int strenght, int gold, String name) {
		super(LifePoints, strenght, gold);
		this.name = name;
	}

	@Override
	public void Die() {
		System.out.println("the Monster is dead");
		Item i = new GoldPurse(this.getGold());
		this.getGame().getCurrentRoom().addItem(i);
		System.out.println("The Monster has drop a gold purse !");
		this.getGame().getCurrentRoom().removeMonster(this);
	}

	@Override
	public String toString() {
		return ("This monster is " + this.name + ", (" + this.getLife() + "HP)");
	}

}
