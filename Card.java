//TODO include picture for each card as attribute
public class Card {
	
	// Private Fields
	private Suit suit;
	private int rank;
	
	// Constructor Method
	public Card(int rank, Suit suit){
		this.rank = rank;
		this.suit = suit;
	}
	
	// Public Methods
	public String getSuit(){
		return suit.printSuit();
	}
	public int getRank(){
		return rank;
	}
	public String toString(){
		String str = " ";
		str += rank + " of " +  suit.printSuit();
		return str;
	}
}
