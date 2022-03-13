package giants;

/**
 * Main Class		Entry point used to bootstrap the program
 * 
 * @author Gray English
 * @version 1.0 3/6/2022
 * @since 1.0
 */

public class Main {
	
	/**
	 * bootstraps the program
	 * 
	 * @param args		program input arguments
	 * @since 1.0
	 */

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.setupSim();
		System.exit(0);
	}

}
