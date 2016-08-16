package wargame;

public class Card {
	private static final int DEFAULT_ERROR_VALUE = 666;
	
	private static char[] validCards = { '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A' };
	private byte currentIndex;
	private char currentCard;

	public Card() {
		this.currentIndex = 0;
		this.currentCard = validCards[currentIndex];
	}

	Card(byte index) {
		setCurrentCardIndexAndValue(index);
	}

	int isFirstCardStrongerThanSecond(Card secondCard) {
		if (secondCard == null) {
			return 1;
		}

		if (secondCard == this) {
			System.out.println("Same card comparing");
			return 0;
		}

		if ((this.currentIndex >= 0) && (this.currentIndex < validCards.length) && (secondCard.currentIndex >= 0)
				&& (secondCard.currentIndex < validCards.length)) {
			if (this.currentIndex > secondCard.currentIndex) {
				return 1;
			} else {
				if (this.currentIndex < secondCard.currentIndex) {
					return -1;
				} else {
					return 0;
				}
			}
		} else {
			return DEFAULT_ERROR_VALUE;
		}

	}

	void setCurrentCardIndexAndValue(byte index) {
		if ((index >= 0) && (index < validCards.length)) {
			this.currentIndex = index;
			this.currentCard = validCards[currentIndex];
		} else {
			System.out.println("Invalid index");
			this.currentIndex = 0;
			this.currentCard = validCards[currentIndex];
			return;
		}
	}

	public static char[] getValidCards() {
		return validCards;
	}

	public byte getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(byte currentIndex) {
		this.currentIndex = currentIndex;
	}

	public char getCurrentCard() {
		return currentCard;
	}

	public void setCurrentCard(char currentCard) {
		this.currentCard = currentCard;
	}
}
