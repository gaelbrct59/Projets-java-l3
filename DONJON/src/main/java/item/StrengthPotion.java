package item;

import Game_Dungeon.Item;
import entities.Player;

/** Get some Strength
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public class StrengthPotion implements Item {

	private int strenght;

	public StrengthPotion(int strenght) {
		this.strenght = strenght;
	}

	@Override
	public void isUsedBy(Player p) {
		p.setStrenght(p.getStrenght() + this.strenght);
		p.getGame().getCurrentRoom().removeItem(this);
	}

	public String toString() {
		return "Strenght potion";
	}

}
