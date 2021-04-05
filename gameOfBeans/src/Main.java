import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 54939_55937
 *
 */

public class Main {

	public static void main(String[] args) throws IOException {
		TurboScanner tScanner = new TurboScanner(System.in); // we want to thank to our colleague Tiago Teles for
																// TurboScanner
		int nGames = tScanner.nextInt();
		//tScanner.nextLine();
		Game[] games = new Game[nGames];
		for (int i = 0; i < nGames; i++) {
			int nPiles = tScanner.nextInt();
			int nDepth = tScanner.nextInt();
			List<Integer> piles = new ArrayList<Integer>(nPiles);
			for (int j = 0; j < nPiles; j++) {
				piles.add(tScanner.nextInt());
			}
			String player = tScanner.nextLine();
			games[i] = new Game(nDepth, piles, player); 
		}
		for(int i=0; i<nGames; i++) {
			System.out.println(games[i].compute());
		}
		tScanner.close();
	}

}
