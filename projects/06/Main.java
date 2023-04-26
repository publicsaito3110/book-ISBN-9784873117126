

import java.io.File;

public class Main {

	public static void main(String[] args) {

		//------------
		// ADD test
		//------------
		Paser paser = new Paser(new File("./add/add.asm"));
		paser.hasMoreCommand();
		paser.advance();
		paser.commandType();
		paser.dest();
	}

}
