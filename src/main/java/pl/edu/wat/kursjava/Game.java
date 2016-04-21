package pl.edu.wat.kursjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Gra.
 *
 * Zmieniłem nazwę z Board na Game - wydaje się rozsądniejsza ;)
 * Przechowuje informacje o planszy oraz "zarządza" grą.
 *
 * Created by elwin013 on 20.04.16.
 */
public class Game {
	private List<String> board;
	private Player firstPlayer;
	private Player secondPlayer;

	public Game() {
		board = new ArrayList<String>();
		init();
	}

	public Game(Player firstPlayer, Player secondPlayer) {
		this();
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
	}

	/**
	 * Metoda czyszcząca tablicę
	 */
	private void init() {
		board.clear();
		for(int i = 0; i < 9; i++) {
			board.add(" ");
		}
	}

	/**
	 * Obsługa gry - kolejne ruchy itp.
	 *
	 * TODO: Obsługa błędów - co jeśli ktoś wpisze jako numer pola np. -1?
	 */
	public void game() {
		init();
		int moves = 0;
		boolean isLegal;
		while(!isSomeoneWin(moves)) {
			isLegal = false;
			int firstPlayerMove;
			do {
				firstPlayerMove = firstPlayer.getMove();
				if(" ".equals(board.get(firstPlayerMove))) {
					isLegal = true;
				}
			} while(!isLegal);
			board.set(firstPlayerMove, "O");
			moves++;
			showBoard();

			if(moves == 9) break;
			isLegal = false;
			int secondPlayerMove;
			do {
				secondPlayerMove = secondPlayer.getMove();
				if(" ".equals(board.get(secondPlayerMove))) {
					isLegal = true;
				}
			} while(!isLegal);
			board.set(secondPlayerMove, "X");
			moves++;
			showBoard();
		}
	}

	/**
	 * Metoda sprawdzająca czy ktoś wygrał grę.
	 * TODO: Sprawdzać algorytmicznie, a nie poprzez pytanie do osoby przy komputerze
	 *
	 * @param moves - liczba ruchów wykonanych do tej pory
	 * @return boolean
	 */
	private boolean isSomeoneWin(int moves) {
		boolean draw = false;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Czy ktos wygral (tak/nie)? ");
		String answer = scanner.nextLine();
		boolean ourAnswer = "tak".equals(answer) ? true : false;
		if(moves == 9) draw = true;
		return ourAnswer || draw;
	}

	/**
	 * Metoda wyświetlająca na ekranie tablicę.
	 */
	private void showBoard() {
		for(int i = 0; i < 9; i++) {
			if(" ".equals(board.get(i))) {
				System.out.print("_ ");
			} else {
				System.out.print(board.get(i) + " ");
			}
			if(i%3 == 2) {
				System.out.println(" ");
			}
		}
		System.out.println(" ");
	}
}
