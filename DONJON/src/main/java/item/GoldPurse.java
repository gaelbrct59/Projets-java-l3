package item;

import Game_Dungeon.Item;
import entities.Player;

/** Win some money
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public class GoldPurse implements Item {

	private int gold;

	public GoldPurse(int numberGold) {
		this.gold = numberGold;
	}

	@Override
	public void isUsedBy(Player p) {

		p.setGold(p.getGold() + this.gold);
		System.out.println(this.toString());
		p.getGame().getCurrentRoom().removeItem(this);
	}

	public String toString() {
		return "Gold Purse";
	}

}
