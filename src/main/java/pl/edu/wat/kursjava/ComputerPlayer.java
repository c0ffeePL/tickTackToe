package pl.edu.wat.kursjava;

import java.util.Random;

/**
 * Gracz komputerowy.
 *
 * Implementacja gracza komputerowego, który wybiera pole
 * w losowy sposób.
 *
 * Created by elwin013 on 20.04.16.
 */
public class ComputerPlayer implements Player {
	private Random random = new Random();

	public int getMove() {
		return random.nextInt(9);
	}
}
