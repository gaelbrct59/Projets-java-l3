package action;

import Game_Dungeon.Action;
import Game_Dungeon.Direction;
import Game_Dungeon.Item;
import Game_Dungeon.Room;
import entities.Monster;
import entities.Player;

/** Look at what is in that room
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public class Look extends Action {
	protected Room room;

	@Override
	public boolean canPerform(Player p) {
		// The player always can check the things into the room
		return true;
	}

	@Override
	public void perform(Player p) {
		// Extract method
		displayAvailableItemIntoTheRoom(p);
		displayAvailableMonsteToAttackAndIssuesIntoTheRoom(p);

	}

	private void displayAvailableMonsteToAttackAndIssuesIntoTheRoom(Player p) {
		System.out.println();
		// S'il y a des monstres : monstres disponnibles + impossible de bouger, issues
		// bloquees
		if (!p.getGame().getCurrentRoom().getMonster().isEmpty()) {
			System.out.println("You can find these monsters in the room :");
			System.out.println();
			for (Monster m : p.getGame().getCurrentRoom().getMonster()) {
				System.out.println("------" + m.toString() + "------");
			}
			System.out.println();
			System.out.println("+++ NO ISSUES ACTUALLY +++");
			// Sinon, pas de monstres ici, issues libres, possibilite de bouger
		} else {
			System.out.println("+++ NO MONSTER HERE +++");
			System.out.println();
			System.out.println("Available issues : ");

			for (Direction d : p.getGame().getCurrentRoom().getNeighborDirections()) {
				System.out.println(d.toString());

			}

		}
		System.out.println();
	}

	private void displayAvailableItemIntoTheRoom(Player p) {
		System.out.println();
		System.out.println("~~~" + p.toString() + "~~~");
		System.out.println();

		if (!p.getGame().getCurrentRoom().getItems().isEmpty()) {
			System.out.println("You can find these Item in the room :");
			System.out.println();
			for (Item i : p.getGame().getCurrentRoom().getItems()) {
				System.out.println("------" + i.toString() + "------");

			}
		} else {
			System.out.println("+++ NO ITEM HERE +++");
		}
	}

	@Override
	public String toString() {
		return "Look at the things into the Room";
	}

}
