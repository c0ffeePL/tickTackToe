package pl.edu.wat.kursjava;

import java.util.Scanner;

/**
 * Gracz-człowiek
 *
 * Implementacja gracza-człowieka, czyli kogoś kto siedzi
 * przy konsoli. Osoba ta podaje numer pola do zaznaczenia.
 *
 * Created by elwin013 on 20.04.16.
 */
public class HumanPlayer implements Player {
	public int getMove() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ktore pole: ");
		int pole = scanner.nextInt();
		return pole;
	}
}
