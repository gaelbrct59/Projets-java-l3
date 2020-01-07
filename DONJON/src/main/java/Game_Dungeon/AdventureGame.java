package Game_Dungeon;

import java.util.ArrayList;
import action.*;
import entities.Monster;
import entities.Player;
import util.*;

/** About game's method
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public class AdventureGame {
	// Initialize the variable to fix monster's capacities
	private static final int MAX_STRENGHT_MONSTER = 5;
	private static final int MIN_STRENGHT_MONSTER = 1;
	private static final int MAX_LIFE_MONSTER = 10;
	private static final int MIN_LIFE_MONSTER = 5;
	private static final int MIN_GOLD_MONSTER = 1;
	private static final int MAX_GOLD_MONSTER = 10;

	// Numbers of turn
	public static int NB_TURN = 0;

	private Player player;
	private Room currentRoom;
	private ArrayList<Action> availableActions;

	public AdventureGame(Room startingRoom) {
		this.currentRoom = startingRoom;
		this.availableActions = new ArrayList<Action>();

		this.addActions();
	}

	/**
	 * Change the room to the new room (create the new room)
	 * 
	 * @param direction : Direction
	 */
	public void playerMoveTo(Direction direction) {

		Direction directionOpposee = direction.opposite();

		// Extract method
		createRoomWithChanceToBeTheLast();

		// Ajout des nouveaux monstres/objets dans la nouvelle room
		// Extract method
		this.currentRoom.createItemsInTheRoom();
		this.createMonstersInTheRoom();

		// Extract method
		addAvailableDirectionExceptOpposite(directionOpposee);

	}

	/**
	 * Create the new room when we move : 33% of chance to be the last, when the
	 * game pass 3 rooms
	 * 
	 */
	private void createRoomWithChanceToBeTheLast() {
		// 33% de chance pour que la prochaine sortie soit bien la derniere
		// La sortie ne peut apparaitre qu'au bout de 3 tours.

		this.currentRoom = new Room();
		if (AdventureGame.NB_TURN > 3 && RandomThings.randomInt(1, 3) == 1) {
			this.getCurrentRoom().setExit(true);
		}
		AdventureGame.NB_TURN++;
		System.out.println("******** Turn number " + AdventureGame.NB_TURN + " ********");
	}

	/**
	 * Add the available direction for the player
	 * 
	 * @param directionOpposee
	 */
	private void addAvailableDirectionExceptOpposite(Direction directionOpposee) {
		// On ajoute les nouvelles direction, sauf celle d'ou on vient.
		if (Direction.EAST != directionOpposee) {
			this.getCurrentRoom().addNeighbors(Direction.EAST, this.getCurrentRoom());
		}
		if (Direction.WEST != directionOpposee) {
			this.getCurrentRoom().addNeighbors(Direction.WEST, this.getCurrentRoom());
		}
		if (Direction.NORTH != directionOpposee) {
			this.getCurrentRoom().addNeighbors(Direction.NORTH, this.getCurrentRoom());
		}
		if (Direction.SOUTH != directionOpposee) {
			this.getCurrentRoom().addNeighbors(Direction.SOUTH, this.getCurrentRoom());
		}
	}

	/**
	 * Create monsters in the room
	 */
	public void createMonstersInTheRoom() {
		@SuppressWarnings("static-access")
		int increaseAccordingToTheTurn = (this.NB_TURN);
		// Put the monsters in the room (between 1 and 3 monsters / room), monsters get
		// better with time
		for (int i = 0; i < RandomThings.randomInt(1, 3); i++) {
			this.addMonster(new Monster(
					RandomThings.randomInt((int) (increaseAccordingToTheTurn) + MIN_LIFE_MONSTER,
							(int) (increaseAccordingToTheTurn) + MAX_LIFE_MONSTER),
					RandomThings.randomInt(increaseAccordingToTheTurn + MIN_STRENGHT_MONSTER,
							increaseAccordingToTheTurn + MAX_STRENGHT_MONSTER),
					RandomThings.randomInt(MIN_GOLD_MONSTER, MAX_GOLD_MONSTER)), this.getCurrentRoom());
		}
	}

	/**
	 * add the monster in the room
	 * 
	 * @param monster : Monster
	 * @param room : Room
	 */
	public void addMonster(Monster monster, Room room) {
		room.addMonster(monster);
		monster.addToGame(this);
	}

	/**
	 * add the item in the room
	 * 
	 * @param item : Item
	 * @param room : Room
	 */
	public void addItem(Item item, Room room) {
		room.addItem(item);
	}

	/**
	 * Method which play while game isn't finished
	 * 
	 * @param p : Player
	 * @throws AlreadyDeadException : If the player who's add has no hp
	 */
	public void play(Player p) throws AlreadyDeadException {
		this.player = p;
		if (p.getLife() > 0) {
			while (!this.isFinished()) {
				p.act();
			}
			if (p.isDead()) {
				p.Die();
			} else {
				System.out.println("You win ! Congratulations");
				System.exit(1);
			}
		} else {
			throw new AlreadyDeadException("Player is aldready dead!");
		}

	}

	/**
	 * Get the Player
	 * 
	 * @return Player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Get the current Room of the player
	 * 
	 * @return Room
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * Add all the available actions in the game
	 * 
	 */
	public final void addActions() {
		this.availableActions.add(new Attack());
		this.availableActions.add(new Rest());
		this.availableActions.add(new Use());
		this.availableActions.add(new Look());
		this.availableActions.add(new Move());
	}

	/**
	 * Get available actions
	 * 
	 * @return the available actions for the player.
	 */
	public ArrayList<Action> getActions() {
		return this.availableActions;
	}

	/**
	 * Check if the game is finished
	 * 
	 * @return boolean
	 */
	public boolean isFinished() {
		// If player is dead, or if the room is the ExitRoom, and there isn't monster
		// here.
		return (this.getPlayer().isDead()
				|| (this.getCurrentRoom().isExit() && this.getCurrentRoom().getMonster().size() == 0));
	}

}
