import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

	private Map<String, Integer> symbolMap = new HashMap<>();


	/**
	 * Constractor
	 *
	 * Road defoult symbol and address
	 *
	 * @param void
	 * @return SymbolTable
	 */
	public SymbolTable() {

		// Set defoult symbol and address
		symbolMap.put("SP", 0);
		symbolMap.put("LCL", 1);
		symbolMap.put("ARG", 2);
		symbolMap.put("THIS",3);
		symbolMap.put("THAT",4);
		symbolMap.put("SCREEN", 16384);
		symbolMap.put("KBD", 24576);
		symbolMap.put("R0", 0);
		symbolMap.put("R1", 1);
		symbolMap.put("R2", 2);
		symbolMap.put("R3", 3);
		symbolMap.put("R4", 4);
		symbolMap.put("R5", 5);
		symbolMap.put("R6", 6);
		symbolMap.put("R7", 7);
		symbolMap.put("R8", 8);
		symbolMap.put("R9", 9);
		symbolMap.put("R10", 10);
		symbolMap.put("R11", 11);
		symbolMap.put("R12", 12);
		symbolMap.put("R13", 13);
		symbolMap.put("R14", 14);
		symbolMap.put("R15", 15);
	}


	/**
	 * Add new symbol and address
	 *
	 * Add new symbol and assigned address.
	 *
	 * @param symbol RAM or ROM of symbol
	 * @param address assigned address
	 * @return void
	 */
	public void addEntry (String symbol, int address) {
		symbolMap.put(symbol, address);
	}


	/**
	 * Chack existing symbol
	 *
	 * Check existing symbol. If it has assigned address.
	 *
	 * @param symbol RAM or ROM of symbol
	 * @return boolean When assigned address.
	 */
	public boolean contains(String symbol) {
		return symbolMap.containsKey(symbol);
	}


	/**
	 * Get Assigned Address
	 *
	 * Return assigned address by symbol.
	 *
	 * @param symbol RAM or ROM of symbol
	 * @return int assigned address
	 */
	public int getAddress(String symbol) {
		return symbolMap.get(symbol);
	}
}
