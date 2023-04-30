

import java.io.File;

public class Main {

	public static void main(String[] args) {

		//------------
		// ADD test
		//------------
		Paser paser = new Paser(new File("./add/add.asm"));
		System.out.println(paser.hasMoreCommand());
		System.out.println(paser.commandType());
		System.out.println(paser.dest());
	}

}
