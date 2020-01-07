package item;

import Game_Dungeon.Item;
import entities.Player;

/** Get some life
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public class LifePotion implements Item {

	private int life;

	public LifePotion(int life) {
		this.life = life;
	}

	@Override
	public void isUsedBy(Player p) {
		p.setLife(p.getLife() + this.life);
		p.getGame().getCurrentRoom().removeItem(this);
	}

	public String toString() {
		return "Life potion";
	}

}
