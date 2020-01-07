package Game_Dungeon;

/** Player or Monster
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public abstract class Character {

	private int LifePoints;
	private int strenght;
	private int gold;
	private AdventureGame game;

	public AdventureGame getGame() {
		return this.game;
	}

	public Character(int pdv, int strenght, int gold) {
		this.LifePoints = pdv;
		this.strenght = strenght;
		this.gold = gold;
	}

	/**
	 * Set the die's effect depend to the character
	 */
	public abstract void Die();

	/**
	 * Check if the character is dead
	 * 
	 * @return boolean
	 */
	public boolean isDead() {
		return this.LifePoints <= 0;
	}

	/**
	 * Add a character to the game
	 * 
	 * @param game : AdventureGame
	 */
	public void addToGame(AdventureGame game) {
		this.game = game;
	}

	/**
	 * Get the life of the character
	 * 
	 * @return int
	 */
	public int getLife() {
		return LifePoints;
	}

	/**
	 * Setter HP
	 * 
	 * @param pdv : int
	 */
	public void setLife(int pdv) {
		this.LifePoints = pdv;
	}

	/**
	 * Get the strength of character
	 * 
	 * @return int
	 */
	public int getStrenght() {
		return strenght;
	}

	/**
	 * Setter strenght
	 * 
	 * @param strenght : int
	 */
	public void setStrenght(int strenght) {
		this.strenght = strenght;
	}

	/**
	 * Get the gold of the character
	 * 
	 * @return int
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * Setter gold
	 * 
	 * @param gold : int
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}

	/**
	 * The character c attack
	 * 
	 * @param c : Character
	 */
	public void attack(Character c) {
		c.setLife(c.getLife() - this.getStrenght());

	}

}
