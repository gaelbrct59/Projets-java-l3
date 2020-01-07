package util;

import java.util.Scanner;
/** Scanner for user
 * @author BRICOUT Gael - BEAREZ Antoine
 */
public class Read {
	static Scanner sc = new Scanner(System.in);
	
	public static final String ScannerAsk() {
		
		String res= sc.nextLine();		
		return res;
	}
}
