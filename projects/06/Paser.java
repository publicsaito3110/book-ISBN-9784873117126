

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

	private static final String PATTERN_SYMBOL_C_COMMAND = "=|;";

	private static final String PATTERN_SYMBOL_L_COMMAND = "^\\([0-9a-zA-Z]\\)+$";


	/**
	 * Constractor
	 *
	 * Param needs Assembly-file path and load. <br>
	 * Reading file and set Assembly code
	 *
	 * @param asmFile Assembly file
	 * @return Paser
	 */
	public Paser(File asmFile) {
		try(Scanner asmScanner = new Scanner(asmFile)) {

			// Roop util finishing read file
			while(asmScanner.hasNextLine()) {
				String asmCode = asmScanner.nextLine();

				// If it's not in no char and comment start
				if (!asmCode.isBlank() && !asmCode.matches("^//.*$")) {

					// Remove comment
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
	 * Read next Assembly commands of row symbol and command.
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

		// Get now Assembly command
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
	 * Row Assembly-symbol. <br>
	 * This method is only called by A_COMMAND or L_COMMAND. <br>
	 * ex) @abc -> abc, (LOOP) -> LOOP...
	 *
	 * @param void
	 * @return String Row Assembly-symbol
	 */
	public String symbol() {
		String asmSynbol = asmList.get(asmListIndexCounter).getAsmSymbol();
		return asmSynbol.replaceAll("@|\\(|\\)", "");
	}


	/**
	 * Now Assembly-command of dest
	 *
	 * Now Assembly-command that a part of dest only. It is row. <br>
	 * This method is called by Conpute-instruction. <br>
	 * ex) dest=comp;jump -> dest
	 *
	 * @param void
	 * @return String Assembly-command of dest
	 */
	public String dest() {
		String asmSynbol = asmList.get(asmListIndexCounter).getAsmSymbol();
		int eqIndex = asmSynbol.indexOf("=");
		return asmSynbol.substring(0, eqIndex);
	}


	/**
	 * Now Assembly-command of comp
	 *
	 * Now Assembly-command that a part of comp only. It is row. <br>
	 * This method is called by Conpute-instruction. <br>
	 * ex) dest=comp;jump -> comp
	 *
	 * @param void
	 * @return String Assembly-command of comp
	 */
	public String comp() {
		String asmSynbol = asmList.get(asmListIndexCounter).getAsmSymbol();
		int eqIndex = asmSynbol.indexOf("=");
		int corIndex = asmSynbol.indexOf(";");
		return asmSynbol.substring(eqIndex, corIndex);
	}


	/**
	 * Now Assembly-command of jump
	 *
	 * Now Assembly-command that a part of jump only. It is row. <br>
	 * This method is called by Conpute-instruction. <br>
	 * ex) dest=comp;jump -> jump
	 *
	 * @param void
	 * @return String Assembly-command of jump
	 */
	public String jump() {
		String asmSynbol = asmList.get(asmListIndexCounter).getAsmSymbol();
		int corIndex = asmSynbol.indexOf(";");
		return asmSynbol.substring(corIndex, asmSynbol.length());
	}


	/**
	 * [private method] Remove NG Chara
	 *
	 * Remove chara of Space, Tab and Comment. <br>
	 *
	 * @param value chara
	 * @return String Removed NG chara
	 */
	private String removeNgChara(String value) {
		String trimValue = value.replaceAll(" |Å@|	", "");
		return trimValue.replace("(?<=//).*$", "");
	}
}


/**
 * Value Object of Assembly State
 *
 * It is maintain Assembly State. <br>
 * It is not called outter, inner only.
 */
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
