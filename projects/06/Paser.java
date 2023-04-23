

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Paser {

	private Scanner asmScanner;

	private String nowAsmSymbol;

	private String nowAsmCommand;

	private static final String A_COMMAND = "A_COMMAND";

	private static final String C_COMMAND = "C_COMMAND";

	private static final String L_COMMAND = "L_COMMAND";

	private static final String PATTERN_SYMBOL_A_COMMAND = "^@[0-9a-zA-Z]+$";

	private static final String PATTERN_SYMBOL_C_COMMAND = "C_COMMAND";

	private static final String PATTERN_SYMBOL_L_COMMAND = "L_COMMAND";


	/**
	 * Constractor
	 *
	 * Param needs Assembly-file path and load. <br>
	 *
	 * @param asmFile Assembly file
	 * @return Paser
	 */
	public Paser(File asmFile) {
		try {
			asmScanner = new Scanner(asmFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Check exist next Assembly-command
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
	 * Read next Assembly-command
	 *
	 * Read next Assembly commands of row symbol and command. <br>
	 * It is row Assembly.
	 *
	 * @param void
	 * @return void
	 */
	public void advance() {
		nowAsmSymbol = asmScanner.nextLine();
		nowAsmCommand = asmScanner.nextLine();
	}


	/**
	 * Now Assembly-command-type. <br>
	 *
	 * Check now Assembly-command-symbol and return this type.
	 *
	 * @param void
	 * @return String Assembly command type <br>
	 * A_COMMAND
	 * C_COMMAND
	 * L_COMMAND
	 */
	public String commandType() {

		if (nowAsmCommand.matches(PATTERN_SYMBOL_A_COMMAND)) {
			return A_COMMAND;
		} else if (nowAsmCommand.matches(PATTERN_SYMBOL_C_COMMAND)) {
			return C_COMMAND;
		} else if (nowAsmCommand.matches(PATTERN_SYMBOL_L_COMMAND)) {
			return L_COMMAND;
		}
		return null;
	}


	/**
	 * Now Assembly-symbol
	 *
	 * Now Assembly-symbol. It is row. <br>
	 * This method is called by Address-instruction.
	 *
	 * @param void
	 * @return String Assembly command type
	 */
	public String symbol() {
		return nowAsmSymbol;
	}


	/**
	 * Now Assembly-command of dest
	 *
	 * Now Assembly-command that a part of dest only. It is row. <br>
	 * This method is called by Conpute-instruction.
	 *
	 * @param void
	 * @return String Assembly-command of dest
	 */
	public String dest() {
		return nowAsmCommand.substring(10, 13);
	}


	/**
	 * Now Assembly-command of comp
	 *
	 * Now Assembly-command that a part of comp only. It is row. <br>
	 * This method is called by Conpute-instruction.
	 *
	 * @param void
	 * @return String Assembly-command of comp
	 */
	public String comp() {
		return nowAsmCommand.substring(3, 10);
	}


	/**
	 * Now Assembly-command of jump
	 *
	 * Now Assembly-command that a part of jump only. It is row. <br>
	 * This method is called by Conpute-instruction.
	 *
	 * @param void
	 * @return String Assembly-command of jump
	 */
	public String jump() {
		return nowAsmCommand.substring(13, 16);
	}
}
