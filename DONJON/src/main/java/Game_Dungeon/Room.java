package Game_Dungeon;

import java.util.ArrayList;
import java.util.HashMap;

import entities.Monster;
import item.*;
import util.RandomThings;

/** About Room's dongeon
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public class Room {
	// Initialize the variable to fix item's capacities

	private static final int STRENGHT_POTION_MAX = 5;
	private static final int STRENGHT_POTION_MIN = 1;
	private static final int LIFE_POTION_MAX = 10;
	private static final int LIFE_POTION_MIN = 5;
	private static final int GOLD_PURSE_MAX = 20;
	private static final int GOLD_PURSE_MIN = 10;

	private ArrayList<Monster> monsters;
	private ArrayList<Item> items;
	private boolean exit;
	private HashMap<Direction, Room> neighbors;

	public Room() {
		this.exit = false;
		this.items = new ArrayList<Item>();
		this.monsters = new ArrayList<Monster>();
		this.neighbors = new HashMap<Direction, Room>();
	}

	/**
	 * Set the actual room the last of game
	 * 
	 * @param exit : boolean
	 */
	public void setExit(boolean exit) {
		this.exit = exit;
	}

	/**
	 * Add and define a neighbor to the room
	 * 
	 * @param direction : Direction
	 * @param room : Room
	 */
	public void addNeighbors(Direction direction, Room room) {
		this.neighbors.put(direction, room);

	}

	/**
	 * get the neighbors's direction
	 * 
	 * @param direction : Direction
	 * @return Room
	 */
	public Room getNeighbor(Direction direction) {
		return this.neighbors.get(direction);
	}

	/**
	 * get the list of neighbors's room
	 * 
	 * @return ArrayList
	 */
	public ArrayList<Direction> getNeighborDirections() {
		return new ArrayList<Direction>(this.neighbors.keySet());
	}

	/**
	 * Add monsters to the List
	 * 
	 * @param m : Monster
	 */
	public void addMonster(Monster m) {
		monsters.add(m);
	}

	/**
	 * Add the Item to the List
	 * 
	 * @param i : Item
	 */
	public void addItem(Item i) {
		items.add(i);
	}

	/**
	 * remove the monster from the list
	 * 
	 * @param m : Monster
	 */
	public void removeMonster(Monster m) {
		monsters.remove(m);
	}

	/**
	 * Remove the Item from the List
	 * 
	 * @param i : Item
	 */
	public void removeItem(Item i) {
		items.remove(i);
	}

	public ArrayList<Monster> getMonster() {
		return this.monsters;
	}
	public ArrayList<Item> getItems() {
		return this.items;
	}

	/**
	 * Check if that room is the Exit (last)
	 * 
	 * @return boolean
	 */
	public boolean isExit() {
		return this.exit;
	}

	/**
	 * create items in the room, depend of chance
	 * 
	 */
	public void createItemsInTheRoom() {
		// Tout augmente en fonction du tour
		int increaseAccordingToTheTurn = AdventureGame.NB_TURN;

		// Put the items in the room (by chance of apparition)
		// Gold purse : between 10 and 20 golds, 50% chance to spawn
		if (RandomThings.randomInt(1, 2) == 1) {
			this.addItem(new GoldPurse(RandomThings.randomInt(increaseAccordingToTheTurn + GOLD_PURSE_MIN,
					increaseAccordingToTheTurn + GOLD_PURSE_MAX)));
		}
		// Life Potion : between 5 and 10 HP, 33% chance to spawn
		if (RandomThings.randomInt(1, 3) == 1) {
			this.addItem(
					new LifePotion(RandomThings.randomInt((int) (increaseAccordingToTheTurn * 1.5) + LIFE_POTION_MIN,
							(int) (increaseAccordingToTheTurn * 1.5) + LIFE_POTION_MAX)));
		}

		// Strenght Potion : between 5 and 10 HP, 25% chance to spawn, no increase with
		// time
		if (RandomThings.randomInt(1, 4) == 1) {
			this.addItem(new StrengthPotion(RandomThings.randomInt(STRENGHT_POTION_MIN, STRENGHT_POTION_MAX)));
		}

		// One Armed Bandit : 25% chance to spawn, no increase with time
		// Need to have at least one item in the room
		if ((RandomThings.randomInt(1, 4) == 1) && this.getItems().size() > 0) {
			this.addItem(new OneArmedBandit());
		}
	}

}
