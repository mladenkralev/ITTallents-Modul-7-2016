package wargame;

public class Player {
	private Deck playersDeck;
	private int score;

	private String name;

	Player(Deck deck, String name) {
		if (deck == null) {
			System.out.println("Give me valid deck dude!");
			return;
		} else {
			this.playersDeck = deck;
		}

		if ((name == null) || (name.equals(""))) {
			System.out.println("Not valid name for player");
			this.name = "unknowned";
			return;
		} else {
			this.name = name;
		}
	}

	public static void showInfoPerson(Player person) {
		System.out.println(
				person.getName() + " won tha hand. His temp score is " + person.getScore());
	}

	void drawCard() {
		playersDeck.getTopCard();
	}

	public Deck getPlayersDeck() {
		return playersDeck;
	}

	public void setPlayersDeck(Deck playersDeck) {
		this.playersDeck = playersDeck;
	}

	public int getScore() {
		return score;
	}

	public String getName() {
		return name;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
