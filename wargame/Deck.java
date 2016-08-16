package wargame;

public class Deck {
	private static final byte QUOTER_OF_DECK = 12;

	Card[] arrayOfCards;
	boolean isEmpty = true;

	public Deck(int lenght) {
		if (lenght <= 0) {
			System.out.println("Leght must be positive");
			return;
		}

		arrayOfCards = new Card[lenght];
	}

	void fillTheDeck() {
		int temp = 0;

		if (!isEmpty) {
			System.out.println("Already Filled");
			return;
		}

		for (int index = 0; index < (arrayOfCards.length); index++) {
			Card tempCard = new Card((byte) temp);
			arrayOfCards[index] = tempCard;
			temp++;

			if (temp == 13) {
				temp = 0;
			}
		}

		int scaller = 0;
		for (int counterOfCards = 0; counterOfCards < 4; counterOfCards++) {
			int counterForRandom = 0;
			for (int index = 0; index < (arrayOfCards.length) / 4; index++) {
				getRadnomNumberWithExclusiveNumbers(Card.getValidCards().length + scaller, counterForRandom);
				counterForRandom++;
			}
			scaller += QUOTER_OF_DECK;
		}

		isEmpty = false;
	}

	void printWholeDeck() {
		if (arrayOfCards == null) {
			System.out.println("No deck");
			return;
		}

		if (arrayOfCards != null) {
			for (int index = 0; index < arrayOfCards.length; index++) {
				if (arrayOfCards[index] == null) {
					System.out.println("No cards");
					return;
				}

				if (arrayOfCards[index] != null) {
					System.out.println((index + 1) + " " + arrayOfCards[index].getCurrentCard());
				}
			}
		}
	}

	boolean hasCardsLeftInTheDeck() {
		return (isEmpty) ? false : true;
	}

	private int getRadnomNumberWithExclusiveNumbers(int end, int counterForRandom) {
		int max = end - counterForRandom + 2;
		int tempRadnom = (int) (Math.random() * max);
		swapCards(tempRadnom, max);
		counterForRandom++;
		return tempRadnom;
	}

	void swapCards(int indexFirst, int indexSecond) {
		Card temp = arrayOfCards[indexFirst];
		arrayOfCards[indexFirst] = arrayOfCards[indexSecond];
		arrayOfCards[indexSecond] = temp;
	}

	Deck getDeckFromThisOne(int start, int end) {
		Deck tempDeck = new Deck(end - start);
		int cardCoutner = 0;
		for (int index = start; index < end; index++) {
			tempDeck.arrayOfCards[cardCoutner] = arrayOfCards[index];
			cardCoutner++;
		}
		tempDeck.isEmpty = false;
		return tempDeck;
	}

	Card getTopCard() {
		isEmpty = true;
		for (int index = (arrayOfCards.length - 1); index >= 0; index--) {
			if (arrayOfCards[index] != null) {
				isEmpty = false;
				Card tempCard = arrayOfCards[index];
				arrayOfCards[index] = null;
				return tempCard;
			}
		}
		if (isEmpty) {
			System.out.println("Deck is empty");
			return null;
		} else {
			System.out.println("Something went wrong!");
			return null;
		}
	}
}
