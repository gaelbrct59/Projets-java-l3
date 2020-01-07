/**
 * 
 */
package item;

import Game_Dungeon.Item;
import entities.Player;
import util.RandomThings;

/** A trader which disapear when we buy a random object
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public class OneArmedBandit implements Item {

	@Override
	public void isUsedBy(Player p) {
		if (p.getGold() < 30) {
			System.out.println("One armed bandit was here but you haven't enough money, too bad!");
		}
		// Si le joueur a assez d'argent
		else {
			switch (RandomThings.randomInt(1, 3)) {
			case (1):
				System.out.println("The Bandit Manchot give you gold purse, + 20 GOLD !");
				p.setGold(p.getGold() + 20);
				break;
			case (2):
				System.out.println("The Bandit Manchot give you strenght potion, + 3 STRENGHT !");
				p.setStrenght(p.getStrenght() + 3);
				break;
			case (3):
				System.out.println("The Bandit Manchot give you Life potion, + 10 HP !");
				p.setLife(p.getLife() + 10);
				break;
			}

			p.setGold(p.getGold() - 30);

		}
		p.getGame().getCurrentRoom().removeItem(this);
	}

	public String toString() {
		return "One armed bandit";
	}

}
