
public class Code {

	//---------------------
	// Const dest command
	//---------------------

	private static final String SYMBOL_DEST_NULL = "NULL";

	private static final String SYMBOL_DEST_M = "M";

	private static final String SYMBOL_DEST_D = "D";

	private static final String SYMBOL_DEST_MD = "MD";

	private static final String SYMBOL_DEST_A = "A";

	private static final String SYMBOL_DEST_AM = "AM";

	private static final String SYMBOL_DEST_AD = "AD";

	private static final String SYMBOL_DEST_AMD = "AMD";

	private static final String BINARY_DEST_NULL = "000";

	private static final String BINARY_DEST_M = "001";

	private static final String BINARY_DEST_D = "010";

	private static final String BINARY_DEST_MD = "011";

	private static final String BINARY_DEST_A = "100";

	private static final String BINARY_DEST_AM = "101";

	private static final String BINARY_DEST_AD = "110";

	private static final String BINARY_DEST_AMD = "111";

	//---------------------
	// Const jump command
	//---------------------

	private static final String BINARY_JUMP_NULL = "000";

	private static final String BINARY_JUMP_JGT = "001";

	private static final String BINARY_JUMP_JEQ = "010";

	private static final String BINARY_JUMP_JGE = "011";

	private static final String BINARY_JUMP_JLT = "100";

	private static final String BINARY_JUMP_JNE = "101";

	private static final String BINARY_JUMP_JLE = "110";

	private static final String BINARY_JUMP_JMP = "111";


	/**
	 * Change binary of dest
	 *
	 * Change Assembly-command to dest's binary <br>
	 * This method is called by Conpute-instruction.
	 *
	 * @param asmCommand Assembly-command
	 * @return String 3Bit dest's binary code
	 */
	public String dest(String asmCommand) {

		// Remove but symbol
		int index = asmCommand.indexOf("=");
		String asmSymbol = asmCommand.substring(0, index);

		if (SYMBOL_DEST_NULL.equals(asmSymbol)) {
			// When symbol is null
			return BINARY_DEST_NULL;
		} else if (SYMBOL_DEST_M.equals(asmSymbol)) {
			// When symbol is M
			return BINARY_DEST_M;
		} else if (SYMBOL_DEST_D.equals(asmSymbol)) {
			// When symbol is D
			return BINARY_DEST_D;
		} else if (SYMBOL_DEST_MD.equals(asmSymbol)) {
			// When symbol is MD
			return BINARY_DEST_MD;
		} else if (SYMBOL_DEST_A.equals(asmSymbol)) {
			// When symbol is A
			return BINARY_DEST_A;
		} else if (SYMBOL_DEST_AM.equals(asmSymbol)) {
			// When symbol is AM
			return BINARY_DEST_AM;
		} else if (SYMBOL_DEST_AD.equals(asmSymbol)) {
			// When symbol is AD
			return BINARY_DEST_AD;
		} else if (SYMBOL_DEST_AMD.equals(asmSymbol)) {
			// When symbol is AMD
			return BINARY_DEST_AMD;
		}
		return null;
	}


	/**
	 * Change binary of comp
	 *
	 * Change Assembly-command to comp's binary <br>
	 * This method is called by Conpute-instruction.
	 *
	 * @param asmCommand Assembly-command
	 * @return String 7Bit comp's binary code
	 */
	public String comp(String asmCommand) {


		return null;
	}


	/**
	 * Change binary of jump
	 *
	 * Change Assembly-command to jump's binary <br>
	 * This method is called by Conpute-instruction.
	 *
	 * @param asmCommand Assembly-command
	 * @return String 3Bit jump's binary code
	 */
	public String jump(String asmCommand) {


		return null;
	}
}
