import java.util.Random;

public class Deck extends Board {
	Random rand = new Random();
	public void populate(){
		for (Suit suit: Suit.values()){
			for (int rank=1; rank<14;rank++){
				Card card = new Card(rank, suit);
				this.add(card);
			}
		}
	}
	public void shuffle(){
		for (int i = cards.size() - 1; i > 0; i--){
			int position= rand.nextInt(i);
			Card randomCard = cards.get(position);
			Card lastCard = cards.get(i);
			swap(randomCard,lastCard);
			//cards.set(i, randomCard);
			//cards.set(position, lastCard);
		}
	}
	public Card getCard(int index) {
		return cards.get(index);
	}
	public int getIndex(Card a) {
		return cards.indexOf(a);
	}
	public void set(int i, Card a) {
		cards.set(i, a);
	}
	public int getLastIndex(Card a) {
		return cards.lastIndexOf(a);
	}
	public void swap(Card a, Card b){
		int pos_a = getIndex(a);
		int pos_b = getIndex(b);
		
		cards.set(pos_a, b);
		cards.set(pos_b, a);
	
	}
}