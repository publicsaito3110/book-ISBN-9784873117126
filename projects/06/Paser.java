

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Paser {

	private List<AsmModule> asmList = new ArrayList<>();

	private int asmListIndexCounter;

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
		try(Scanner asmScanner = new Scanner(asmFile)) {

			//
			while(asmScanner.hasNextLine()) {
				String asmCode = asmScanner.nextLine();

				// If
				if (!asmCode.isBlank() && !asmCode.matches("^//.*$")) {

					// Remove
					String asmSymbol = removeNgChara(asmCode);
					String asmCommand = removeNgChara(asmScanner.nextLine());
					asmList.add(new AsmModule(asmSymbol, asmCommand));
				}
			}
		} catch (Exception e) {
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
		return asmListIndexCounter < asmList.size();
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
		asmListIndexCounter++;
	}


	/**
	 * Now Assembly-command-type. <br>
	 *
	 * Check now Assembly-command-symbol and return this type.
	 *
	 * @param void
	 * @return String Assembly command type
	 */
	public String commandType() {

		//
		AsmModule asmModule = asmList.get(asmListIndexCounter);
		String nowAsmSymbol = asmModule.getAsmSymbol();

		if (nowAsmSymbol.matches(PATTERN_SYMBOL_A_COMMAND)) {
			return A_COMMAND;
		} else if (nowAsmSymbol.matches(PATTERN_SYMBOL_C_COMMAND)) {
			return C_COMMAND;
		} else if (nowAsmSymbol.matches(PATTERN_SYMBOL_L_COMMAND)) {
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
		AsmModule asmModule = asmList.get(asmListIndexCounter);
		return asmModule.getAsmSymbol();
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
		return null;
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
		return null;
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
		return null;
	}


	private String removeNgChara(String value) {
		String trimValue = value.replaceAll("^[\r\n|\r|\n|\t].$", "");
		return trimValue.replace("(?<=//).*$", "");
	}
}


class AsmModule {

	private String asmSymbol;

	private String asmCommand;


	// All args constracor
	public AsmModule(String asmSymbol, String asmCommand) {
		this.asmSymbol = asmSymbol;
		this.asmCommand = asmCommand;
	}

	// Getter and Setter
	public void setAsmSymbol(String asmSymbol) {
		this.asmSymbol = asmSymbol;
	}
	public String getAsmSymbol() {
		return asmSymbol;
	}
	public void setAsmCommand(String asmCommand) {
		this.asmCommand = asmCommand;
	}
	public String getAsmCommand() {
		return asmCommand;
	}
}
