
public enum Suit {
	DIAMONDS("diamonds"),
	CLUBS("Clubs"),
	HEARTS("Hearts"),
	SPADES("Spades");
	
	private final String suitText;
	
	// Constructor
	private Suit(String suitText){
		this.suitText = suitText;
	}
	
	// Public Method
	public String printSuit(){
		return suitText;
	}

	
}
