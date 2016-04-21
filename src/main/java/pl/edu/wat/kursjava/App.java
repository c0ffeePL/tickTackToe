package pl.edu.wat.kursjava;

/**
 * Wejście do naszej aplikacji.
 *
 * Created by elwin013 on 20.04.16.
 */
public class App {
	public static void main(String[] args) {
		// Tworzymy graczy
		Player firstPlayer = new HumanPlayer();
		Player secondPlayer = new ComputerPlayer();

		// Tworzymy grę
		Game game = new Game(firstPlayer, secondPlayer);

		// Gramy
		game.game();

	}
}
