package util;

import java.util.ArrayList;
import java.util.Random;

/** Random things
 * @author BRICOUT Gael - BEAREZ Antoine
 *
 */
public class RandomThings {
	public static int randomInt(int min, int max) {
		return new Random().nextInt((max - min) + 1) + min;
	}

	/**
	 * Get some monster's name
	 * 
	 * @return String
	 */
	public static String randomNameMonster() {
		ArrayList<String> availableNames = new ArrayList<String>();
		availableNames.add("C language");
		availableNames.add("Alien");
		availableNames.add("Dark Vador");
		availableNames.add("Voldemort");
		availableNames.add("Gargamel");
		availableNames.add("Captain hook");
		availableNames.add("Thanos");
		availableNames.add("Hannibal Lecter");
		availableNames.add("Jafar");

		return availableNames.get(RandomThings.randomInt(0, availableNames.size() - 1));
	}
}
