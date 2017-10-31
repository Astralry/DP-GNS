import java.util.ArrayList;


public class Board {
	
	// Attributes
	public ArrayList<Card> cards;
	
	// Constructor
	public Board(){
		cards = new ArrayList<Card>();
	}
	
	// Public Methods
	public void clear(){
		cards.clear();
	}
	public void add(Card card){
		cards.add(card);
	}
	public void remove(Card card) {
		cards.remove(card);
	}
	public String printDeck(){
		String deck = "";
		for (int i = 0; i < 52; i++){
			Card card = cards.get(i);
			deck += card.toString() + "\n";
		}
		return deck;
	}
}