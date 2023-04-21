

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Paser {

	private Scanner asmScanner;

	private String nowAsmCommand;

	private final String A_COMMAND = "A_COMMAND";

	private final String C_COMMAND = "C_COMMAND";

	private final String L_COMMAND = "L_COMMAND";


	/**
	 * Constractor
	 *
	 * @param asmFile Assembly file
	 * @return Paser
	 */
	public Paser(File asmFile) {
		try {
			asmScanner = new Scanner(asmFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();;
		}
	}


	/**
	 * Check input Assembly command
	 *
	 * @param void
	 * @return boolean <br>
	 * true: Exit command <br>
	 * false: No command
	 */
	public boolean hasMoreCommand() {
		return asmScanner.hasNextLine();
	}


	/**
	 * Read next Assembly command
	 *
	 * @param void
	 * @return void
	 */
	public void advance() {
		nowAsmCommand = asmScanner.nextLine();
	}


	/**
	 * now Assembly command type<br>
	 *
	 *
	 * @param void
	 * @return String Assembly command type <br>
	 * A_COMMAND
	 * C_COMMAND
	 * L_COMMAND
	 */
	public String commandType() {
		return null;
	}
}
