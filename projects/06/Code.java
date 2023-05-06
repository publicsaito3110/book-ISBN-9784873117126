import java.util.HashMap;
import java.util.Map;

public class Code {

	private Map<String, String> destMap = new HashMap<>();

	private Map<String, String> compMap = new HashMap<>();

	private Map<String, String> jumpMap = new HashMap<>();


	/**
	 * Constractor
	 *
	 * Road defoult C-instruction's binary of 'dest', 'comp' and 'jump'
	 *
	 * @param void
	 * @return SymbolTable
	 */
	public Code() {

		// Set dest binary
		destMap.put(null, "000");
		destMap.put("0", "000");
		destMap.put("M", "001");
		destMap.put("D", "010");
		destMap.put("MD", "011");
		destMap.put("A", "100");
		destMap.put("AM", "101");
		destMap.put("AD", "110");
		destMap.put("AMD", "111");

		// Set comp binary
		compMap.put("A>>", "010000000");
		compMap.put("D>>", "010010000");
		compMap.put("A<<", "010100000");
		compMap.put("D<<", "010110000");
		compMap.put("M>>", "011000000");
		compMap.put("M<<", "011100000");
		compMap.put("0", "110101010");
		compMap.put("1", "110111111");
		compMap.put("-1", "110111010");
		compMap.put("D", "110001100");
		compMap.put("A", "110110000");
		compMap.put("!D", "110001101");
		compMap.put("!A", "110110001");
		compMap.put("-D", "110001111");
		compMap.put("-A", "110110011");
		compMap.put("D+1", "110011111");
		compMap.put("A+1", "110110111");
		compMap.put("D-1", "110001110");
		compMap.put("A-1", "110110010");
		compMap.put("D+A", "110000010");
		compMap.put("D-A", "110010011");
		compMap.put("A-D", "110000111");
		compMap.put("D&A", "110000000");
		compMap.put("D|A", "110010101");
		compMap.put("M", "111110000");
		compMap.put("!M", "111110001");
		compMap.put("-M", "111110011");
		compMap.put("M+1", "111110111");
		compMap.put("M-1", "111110010");
		compMap.put("D+M", "111000010");
		compMap.put("D-M", "111010011");
		compMap.put("M-D", "111000111");
		compMap.put("D&M", "111000000");
		compMap.put("D|M", "111010101");

		// Set jump binary
		jumpMap.put(null, "000");
		jumpMap.put("JGT", "001");
		jumpMap.put("JEQ", "010");
		jumpMap.put("JGE", "011");
		jumpMap.put("JLT", "100");
		jumpMap.put("JNE", "101");
		jumpMap.put("JLE", "110");
		jumpMap.put("JMP", "111");
	}


	/**
	 * Change binary of dest
	 *
	 * Change Assembly-mnemonic to dest's binary. <br>
	 * This method is called by Conpute-instruction. <br>
	 * ex) 0 -> 000, M -> 001...
	 *
	 * @param mnemonic Assembly-mnemonic
	 * @return String 3Bit dest's binary code
	 */
	public String dest(String mnemonic) {
		return destMap.get(mnemonic);
	}


	/**
	 * Change binary of comp
	 *
	 * Change Assembly-mnemonic to comp's binary. <br>
	 * This method is called by Conpute-instruction. <br>
	 * ex) 0 -> 110101010, 1 -> 110111111...
	 *
	 * @param mnemonic Assembly-mnemonic
	 * @return String 7Bit comp's binary code
	 */
	public String comp(String mnemonic) {
		return compMap.get(mnemonic);
	}


	/**
	 * Change binary of jump
	 *
	 * Change Assembly-mnemonic to jump's binary. <br>
	 * This method is called by Conpute-instruction. <br>
	 * ex) JGT -> 001, JEQ -> 010...
	 *
	 * @param mnemonic Assembly-mnemonic
	 * @return String 3Bit jump's binary code
	 */
	public String jump(String mnemonic) {
		return jumpMap.get(mnemonic);
	}
}
