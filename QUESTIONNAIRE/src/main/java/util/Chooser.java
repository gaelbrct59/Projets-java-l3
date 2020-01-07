package util;

import java.util.List;

/** Ask to the player to choice in a list of choices
 * @author BRICOUT Gael - BEAREZ Antoine
 * 
 */
public class Chooser {
	/**
	 * Get the choice of the user.
	 * 
	 * @param list : List
	 * @param msg : String
	 * @param <T> : parameters type
	 * @return choice of user
	 */
	public static <T> T choose(List<T> list, String msg) {
		int i = 1;

		System.out.println(msg);
		for (T elmnt : list) {

			System.out.println(i + " : " + elmnt.toString());
			i++;
		}

		int j = ScannerInt.readInt(list.size() + 1);
//		if (j == 0) {
//			return null;
//		}
		return (T) list.get(j - 1);

	}

}
