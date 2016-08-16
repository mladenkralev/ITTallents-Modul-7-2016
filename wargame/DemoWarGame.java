package wargame;

import java.util.Scanner;

import homework2.car.Person;

public class DemoWarGame {
	private static final int CARDS_WITCH_ARE_IN_SINGLE_HAND = 2;
	private static final int CARDS_DRAWNED_FOR_WAR = 3;

	private static final int FLAG_FOR_ENDED_GAME = 1;
	private static final int FLAG_FOR_NOT_ENDED_GAME = 2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Deck deckFirst = new Deck(52);
		deckFirst.fillTheDeck();
		Deck firstDeck = deckFirst.getDeckFromThisOne(0, 26);
		Deck seconddeck = deckFirst.getDeckFromThisOne(26, 52);

		Player firstPlayer = new Player(firstDeck, "Mladen");
		Player secondPlayer = new Player(seconddeck, "Kiro");

		startGame(firstPlayer, secondPlayer);

	}

	static void startGame(Player firstPlayer, Player secondPlayer) {
		Scanner sc = new Scanner(System.in);
		int cardDrawned = 1;

		while ((firstPlayer.getPlayersDeck().hasCardsLeftInTheDeck())
				&& (secondPlayer.getPlayersDeck().hasCardsLeftInTheDeck())) {
			Card tempCardOne = firstPlayer.getPlayersDeck().getTopCard();
			Card tempCardTwo = secondPlayer.getPlayersDeck().getTopCard();

			if (checkIfGameEnds(firstPlayer, secondPlayer, tempCardOne, tempCardTwo) == FLAG_FOR_ENDED_GAME) {
				return;
			}

			showCardsOnTable(firstPlayer, secondPlayer, tempCardOne, tempCardTwo);

			if (tempCardOne.isFirstCardStrongerThanSecond(tempCardTwo) == 1) {
				firstPlayer.setScore(firstPlayer.getScore() + CARDS_WITCH_ARE_IN_SINGLE_HAND);
				Player.showInfoPerson(firstPlayer);
			} else {
				if (tempCardOne.isFirstCardStrongerThanSecond(tempCardTwo) == -1) {
					secondPlayer.setScore(secondPlayer.getScore() + CARDS_WITCH_ARE_IN_SINGLE_HAND);
					Player.showInfoPerson(secondPlayer);
				} else {
					int tempScore = CARDS_WITCH_ARE_IN_SINGLE_HAND;
					
					System.out.println("Voina stana");
					
					for (int index = 0; index < CARDS_DRAWNED_FOR_WAR; index++) {
						tempCardOne = firstPlayer.getPlayersDeck().getTopCard();
						tempCardTwo = secondPlayer.getPlayersDeck().getTopCard();

						if (checkIfGameEnds(firstPlayer, secondPlayer, tempCardOne,
								tempCardTwo) == FLAG_FOR_ENDED_GAME) {
							return;
						}
						showCardsOnTable(firstPlayer, secondPlayer, tempCardOne, tempCardTwo);
						tempScore += CARDS_WITCH_ARE_IN_SINGLE_HAND;
					}

					while ((tempCardOne.isFirstCardStrongerThanSecond(tempCardTwo) == 0)) {
						tempCardOne = firstPlayer.getPlayersDeck().getTopCard();
						tempCardTwo = secondPlayer.getPlayersDeck().getTopCard();

						if (checkIfGameEnds(firstPlayer, secondPlayer, tempCardOne,
								tempCardTwo) == FLAG_FOR_ENDED_GAME) {
							return;
						}
						showCardsOnTable(firstPlayer, secondPlayer, tempCardOne, tempCardTwo);
						tempScore += CARDS_WITCH_ARE_IN_SINGLE_HAND;
					}

					if (tempCardOne.isFirstCardStrongerThanSecond(tempCardTwo) == 1) {
						firstPlayer.setScore(firstPlayer.getScore() + tempScore);
						Player.showInfoPerson(firstPlayer);
					}

					if (tempCardOne.isFirstCardStrongerThanSecond(tempCardTwo) == -1) {
						secondPlayer.setScore(secondPlayer.getScore() + tempScore);
						Player.showInfoPerson(secondPlayer);

					}
				}
			}
			System.out.println(cardDrawned + " card drawned");
			System.out.println("Continue? (Y/N)");
			char tempChar = sc.next().toUpperCase().charAt(0);

			if (tempChar == 'N') {
				break;
			}

			if (tempChar == 'Y') {
				cardDrawned++;
				continue;
			}
		}
	}

	private static void showCardsOnTable(Player firstPlayer, Player secondPlayer, Card tempCardOne, Card tempCardTwo) {
		System.out.println(firstPlayer.getName() + " iztegli " + tempCardOne.getCurrentCard());
		System.out.println(secondPlayer.getName() + " iztegli " + tempCardTwo.getCurrentCard());
	}

	private static int checkIfGameEnds(Player firstPlayer, Player secondPlayer, Card tempCardOne, Card tempCardTwo) {
		if ((tempCardOne == null) || (tempCardTwo == null)) {
			System.out.println("Game Has ended");
			Player.showInfoPerson(firstPlayer);
			Player.showInfoPerson(secondPlayer);
			return FLAG_FOR_ENDED_GAME;
		} else {
			return FLAG_FOR_NOT_ENDED_GAME;
		}
	}
}
